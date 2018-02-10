sqoop import --target-dir /user/vagrant/widgets1 --connect jdbc:mysql://localhost/hadoopguide --table widgets  \
 --where "id >= 1000 and id <= 3000" -m 1 --username root --password itmd521