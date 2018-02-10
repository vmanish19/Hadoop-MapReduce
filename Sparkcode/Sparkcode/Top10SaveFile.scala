
var copyDF=top10.withColumn("only",concat_ws("\t",$"CategoryName",$"ProductName",$"ProductPrice"))

copyDF.select("only").coalesce(1).write.text("/vagrant_data/Result_1/textFile");

