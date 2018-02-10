 
 
import com.databricks.spark.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window



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

