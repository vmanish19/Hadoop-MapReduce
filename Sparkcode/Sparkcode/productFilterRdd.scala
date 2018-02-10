import com.databricks.spark.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window


val filterRDD = product.map(s=>new Tuple5(s.getString(0),s.getString(1),s.getString(2),s.getString(3),s.getString(4))).filter(tuple5=>tuple5._4!="").
filter(tuple5=>tuple5._4.toFloat<100)

filterRDD.take(20).foreach(println)
