import com.databricks.spark.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

val product = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/products/products.avro").rdd

val category = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/categories/categories.avro").rdd


product.take(20).foreach(println)

category.take(20).foreach(println)


val filterRDD = product.map(s=>new Tuple5(s.getString(0),s.getString(1),s.getString(2),s.getString(3),s.getString(4))).filter(tuple5=>tuple5._4!="").
filter(tuple5=>tuple5._4.toFloat<100)

filterRDD.take(20).foreach(println)


 val product = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/products/products.avro").rdd

 val category = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/categories/categories.avro").rdd

 val filterRDD = product.map(s=>new Tuple5(s.getString(0),s.getString(1),s.getString(2),s.getString(3),s.getString(4))).filter(tuple5=>tuple5._4!="").
 filter(tuple5=>tuple5._4.toFloat<100)

 val filtercategory = category.map(s=>new Tuple2(s.getString(0), s.getString(1)))

 val dfproducttemp = spark.createDataFrame(filterRDD).toDF("id","category_id","name","price","url")

 val dfproduct = dfproducttemp.select($"id" , $"category_id" , $"name" ,  $"price".cast("float") , $"url").
                 toDF("id","category_id","name","price","url")

 val dfcategory = spark.createDataFrame(filtercategory).toDF("category_id","category_name")

 val joindf= dfproduct.join(dfcategory, "category_id")

 val window = Window.partitionBy("category_id").orderBy(desc("price"))

 val res = joindf.withColumn("r", row_number.over(window)).where($"r" <= 10)

 val top10 = res.select("category_name","name","price").toDF("CategoryName" , "ProductName", "ProductPrice")

 top10.show()



val window1 = Window.partitionBy("category_id").orderBy(desc("price"))

val dfMax = joindf.withColumn("rn", row_number.over(window1)).where($"rn" === 1).drop("rn")

val window2 = Window.partitionBy("category_id").orderBy("price" )

val dfMin = joindf.withColumn("rn", row_number.over(window2)).where($"rn" === 1).drop("rn")

val tmax = dfMax.select("category_id","category_name","name","price").toDF("category_id","category_name","MaxProductName", "MaxPrice")

val tmin = dfMin.select("category_id","name","price").toDF("category_id","MinProductName", "MinPrice")

val finalresult = tmax.join(tmin, "category_id")

val MaxMin = finalresult.select("category_name","MaxProductName", "MaxPrice","MinProductName", "MinPrice").
             toDF("category_name","MaxProductName", "MaxPrice", "MinProductName", "MinPrice")

MaxMin.show(100)
