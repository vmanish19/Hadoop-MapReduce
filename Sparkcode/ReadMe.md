
# Steps to run application

### You can execute code in two way:

* Run only step 1: It will execute all the scala file and display output on command lines  OR
* Run step 2 to 7 in spark-shell


#### 1) Download Week13Spark.sh and Week13Spark.scala from code folder and use command sh Week13Spark.sh to run it

##### Please Note: Make sure your Week13Spark.sh and Week13Spark.scala should be on same path

![Week13Spark.sh](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/Week13Spark.sh)
![Week13Spark.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/Week13Spark.scala)



------------------


#### 2) Close your spark scala shell.

------------------

#### 3) Download startSpark.sh from code folder and use command sh startSpark.sh to run it
![startSpark.sh](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/startSpark.sh)

   **Please Note:Before running this command close the spark scala shell otherwise error may occurs on futher commands.**

------------------

#### 4) Copy the command from Top20RowsRdd.scala in code folder and paste it into spark scala shell
![Top20RowsRdd.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/Top20RowsRdd.scala)

* Output Result
![Result.JPG](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result.JPG)
--------------------------

#### 5) Copy the command from productFilterRdd.scala in code folder and paste it into spark scala shell
![productFilterRdd.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/productFilterRdd.scala)

* Output Result 

     ![res1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_0-filter.JPG)

* Output Result_0.txt
![Result_0.txt](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_0.txt)

** Please Note:Command to save data in txt file is in FilterRddSave.scala**
   ![FilterRddSave.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/FilterRddSave.scala)

--------------------------


#### 6) Copy the command from Top10ProductPrice.scala in code folder and paste it into spark scala shell
![Top10ProductPrice.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/Top10ProductPrice.scala)

* Output Result 

![res2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_1.JPG)
* Output Result_1.txt
   ![Result_1.txt](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_1.txt)

** Please Note:Command to save data in txt file is in Top10SaveFile.scala**
   ![Top10SaveFile.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/Top10SaveFile.scala)

-----------------------------

#### 7) Copy the command from HigLowProductPrice.scala in code folder and paste it into spark scala shell
![HigLowProductPrice.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/HigLowProductPrice.scala)

* Output Result 
![res3](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_2.JPG)

* Output Result_2.avro
        ![Result_2.avro](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/Results/Result_2.avro)

** Please Note:Command to save data in avro file is in HigLowPriceSaveFile.scala**
        ![HigLowPriceSaveFile.scala](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-13/code/HigLowPriceSaveFile.scala)



