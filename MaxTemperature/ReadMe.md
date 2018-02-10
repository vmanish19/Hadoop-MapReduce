
# Steps to run application

* To install MYSQL dowload the install_mysql.sh script in your vagrant folder(/vagrant) and run it. Give password "itmd521" when password is asked.

![install_mysql.sh](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-04/scripts)

------------------

* Keep combined two years files in your vagrant data folder('/vagrant_data/') and give below name to your file.
  	* 9091-sample.txt 
 	* 9293-sample.txt

----------------

* To create database, two tables and insert record into tables download 90919293.sh script in your vagrant folder(/vagrant) and run it. Give password "itmd521" when asked. 

![90919293.sh](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-04/scripts)

--------------------------

* Place Mysql jar your vagrant folder(/vagrant). Compile and run Maxtemperature9091.java and Maxtemperature9293.java to get below result.

9091

![Maxtemperature9091.java](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-04/code)

![Output](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-04/images/9091_java1.JPG)

9293

![Maxtemperature9293.java](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-04/code)

![Output](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-04/images/9293_java.JPG)

-----------------------------
**note:** 
Script will fail because of following reason:

* If script not place is proper path:
Issue pwd command and check path it should display only '/vagrant'. Issue ls command and check whether you can find the above two script file under vagrant folder.

* If two files note placed in ('/vagrant_data/') folder:
Issue pwd command and check path it should display only '/vagrant_data'. Issue ls command and check whether you can find the files two under vagrant_data folder.

* Wrong output: If two tables are already present in temperature database with mismatch field length.



