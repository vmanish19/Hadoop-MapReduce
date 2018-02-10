
import com.databricks.spark.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

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

