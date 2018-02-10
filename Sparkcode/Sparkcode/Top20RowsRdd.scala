import com.databricks.spark.avro._
import org.apache.spark.SparkContext._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.Window

val product = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/products/products.avro").rdd

val category = spark.read.avro("hdfs://localhost:9000/user/vagrant/mrv/data/categories/categories.avro").rdd


product.take(20).foreach(println)

category.take(20).foreach(println)
