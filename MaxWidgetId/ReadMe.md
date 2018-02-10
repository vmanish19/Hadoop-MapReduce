
# Steps to run application

* 1) Download create.sql from scripts folder and use command "mysql -u root -p < create.sql" to run it. Give password "itmd521" when password is asked.

![create.sql](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-11/scripts)

------------------

* 2) Download step-2.sql from scripts folder and use command "mysql -u root -p < step-2.sql" to run it. Give password "itmd521" when password is asked.

![step-2.sql](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-11/scripts)

--------------------------

* 3) Download step-3.sh from scripts folder and use command "sh step-3.sh" to run it.

![step-3.sh](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-11/scripts)


--------------------------


* 4) Download step-4.sh from scripts folder and use command "sh step-4.sh" to run it.

![step-4.sh](https://github.com/illinoistech-itm/mvishwakarma/tree/master/ITMD-521/Week-11/scripts)


-----------------------------

* 5) “Working with Imported data”.

![Working with Imported data](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-11/images/%E2%80%9CWorking%20with%20Imported%20data.JPG)
![19888-Working with Imported data](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-11/images/19888-Working%20With%20Data.JPG)

-----------------------------


* 6) “Average Price for each widgets”- Compile MaxWidgetId.java code and run jar file

![Average Price](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-11/images/avg.JPG)
![19888-Average Price](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-11/images/avg_19888.JPG)


-----------------------------------
Sql Output
![sql-Average Price](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-11/images/sql_output.JPG)

-----------------------------

**Note:** To run MaxWidgetId.java use below command

* Compile :hadoop com.sun.tools.javac.Main MaxWidgetId.java Widget.java
* Jar : jar cf sqoop-example.jar *.class
* Run :hadoop jar  sqoop-example.jar MaxWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar





