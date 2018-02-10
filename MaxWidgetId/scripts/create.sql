DROP DATABASE IF EXISTS hadoopguide;
CREATE DATABASE hadoopguide;

use hadoopguide;

DROP TABLE IF EXISTS widgets;
CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
widget_name VARCHAR(64) NOT NULL,   
price DECIMAL(10,2),   
design_date DATE,    
VERSION INT,    
design_comment VARCHAR(100)
); 

