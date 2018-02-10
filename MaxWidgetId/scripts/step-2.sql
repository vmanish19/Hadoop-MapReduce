DROP DATABASE IF EXISTS hadoopguide;
CREATE DATABASE hadoopguide;
USE hadoopguide;
DROP TABLE IF EXISTS widgets;
CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
widget_name VARCHAR(64) NOT NULL,   
price DECIMAL(10,2),   
design_date DATE,    
VERSION INT,    
design_comment VARCHAR(100)
); 


DROP PROCEDURE IF EXISTS load_widgets;

DELIMITER #
CREATE PROCEDURE load_widgets()
BEGIN

DECLARE v_max INT UNSIGNED DEFAULT 4997;
DECLARE v_counter INT UNSIGNED DEFAULT 0;

  TRUNCATE TABLE widgets;
  START TRANSACTION;
  INSERT INTO widgets VALUES (NULL, 'sprocket', 0.25, '2010-02-10', 1, 'Connects two gizmos');  
   INSERT INTO widgets VALUES (NULL, 'gizmo', 4.00, '2009-11-30', 4,   'Connects two gizmos');  
   INSERT INTO widgets VALUES (NULL, 'gadget', 99.99, '1983-08-13',   13, 'Our flagship product'); 
  WHILE v_counter < v_max DO
INSERT INTO
  widgets 
  SELECT NULL, f1.widget_name, f2.price, f3.design_date, f4.VERSION, f5.design_comment FROM(
  (SELECT widget_name FROM widgets ORDER BY RAND()LIMIT 1) AS f1,
  
  (SELECT price FROM widgets ORDER BY RAND()LIMIT 1) AS f2,
   
  (SELECT design_date FROM widgets ORDER BY RAND()LIMIT 1) AS f3,
   
  (SELECT VERSION FROM  widgets ORDER BY RAND()LIMIT 1) AS f4,
  
  (SELECT design_comment FROM widgets ORDER BY RAND()LIMIT 1) AS f5
  );

    SET v_counter=v_counter+1;
  END WHILE;
  COMMIT;
END #

DELIMITER ;

CALL load_widgets();
