 #!/bin/sh
# connectivity
 mysql -u root  -p   << eof
create database if not exists temperature;
use  temperature;
CREATE TABLE IF NOT EXISTS 9091sample (
      filler1 varchar(04),
      weatherst varchar(6),
      wban varchar (5),
      obsdate varchar(8),
      obshr varchar(4),
      unkownno varchar(1),
      latitude varchar(6),
      longitude varchar(7),
      fmdata varchar(5),
      elevation varchar(5),
      placehold varchar(5),
      placehold1 varchar(4),
      winddata varchar(3),
      quality varchar(1),
      place3 varchar(1),
      place4 varchar(4),
      place5 varchar(1),
      place6 varchar(1),
      place7 varchar(5),
      place8 varchar(1),
      place9 varchar(1),
      visibiltydst varchar(6),
      qualitycode varchar(1),
      place10 varchar(1),
      place11 varchar(1),
      place12 varchar(1),
      temp varchar(5),
      qualitycd2 varchar(1),
      dewpoint varchar(5),
      qualitycd4 varchar(1),
      atmosprs varchar(5),
      quality8 varchar(1)

    ) Engine=InnoDB ;

LOAD DATA LOCAL INFILE '/vagrant_data/9091-sample.txt'
INTO TABLE 9091sample
(@row)
SET filler1= TRIM(SUBSTR(@row,1,4)),
    weatherst= TRIM(SUBSTR(@row,5,10)),
    wban= TRIM(SUBSTR(@row,11,15)),
    obsdate= TRIM(SUBSTR(@row,16,23)),
    obshr= TRIM(SUBSTR(@row,24,27)),
    unkownno= TRIM(SUBSTR(@row,28,29)),
    latitude= TRIM(SUBSTR(@row,29,34)),
    longitude= TRIM(SUBSTR(@row,35,41)),
    fmdata= TRIM(SUBSTR(@row,42,46)),
    elevation= TRIM(SUBSTR(@row,47,51)),
    placehold= TRIM(SUBSTR(@row,52,56)),
    placehold1= TRIM(SUBSTR(@row,57,60)),
    winddata= TRIM(SUBSTR(@row,61,63)),
    quality= TRIM(SUBSTR(@row,64,64)),
    place3= TRIM(SUBSTR(@row,65,65)),
    place4= TRIM(SUBSTR(@row,66,69)),
    place5= TRIM(SUBSTR(@row,70,70)),
    place6= TRIM(SUBSTR(@row,71,71)),
    place7= TRIM(SUBSTR(@row,72,76)),
    place8= TRIM(SUBSTR(@row,77,77)),
    place9= TRIM(SUBSTR(@row,78,78)),
    visibiltydst= TRIM(SUBSTR(@row,79,84)),
    qualitycode= TRIM(SUBSTR(@row,85,85)),
    place10= TRIM(SUBSTR(@row,86,86)),
    place11= TRIM(SUBSTR(@row,87,87)),
    place12= TRIM(SUBSTR(@row,88,88)),
    temp= TRIM(SUBSTR(@row,88,93)),
    qualitycd2= TRIM(SUBSTR(@row,93,93)),
    dewpoint= TRIM(SUBSTR(@row,94,98)),
    qualitycd4= TRIM(SUBSTR(@row,99,99)),
    atmosprs= TRIM(SUBSTR(@row,100,104)),
    quality8= TRIM(SUBSTR(@row,104,104))
    
;
CREATE TABLE IF NOT EXISTS 9293sample (
      filler1 varchar(04),
      weatherst varchar(6),
      wban varchar (5),
      obsdate varchar(8),
      obshr varchar(4),
      unkownno varchar(1),
      latitude varchar(6),
      longitude varchar(7),
      fmdata varchar(5),
      elevation varchar(5),
      placehold varchar(5),
      placehold1 varchar(4),
      winddata varchar(3),
      quality varchar(1),
      place3 varchar(1),
      place4 varchar(4),
      place5 varchar(1),
      place6 varchar(1),
      place7 varchar(5),
      place8 varchar(1),
      place9 varchar(1),
      visibiltydst varchar(6),
      qualitycode varchar(1),
      place10 varchar(1),
      place11 varchar(1),
      place12 varchar(1),
      temp varchar(5),
      qualitycd2 varchar(1),
      dewpoint varchar(5),
      qualitycd4 varchar(1),
      atmosprs varchar(5),
      quality8 varchar(1)

    ) Engine=InnoDB ;

LOAD DATA LOCAL INFILE '/vagrant_data/9293-sample.txt'
INTO TABLE 9293sample
(@row)
SET filler1= TRIM(SUBSTR(@row,1,4)),
    weatherst= TRIM(SUBSTR(@row,5,10)),
    wban= TRIM(SUBSTR(@row,11,15)),
    obsdate= TRIM(SUBSTR(@row,16,23)),
    obshr= TRIM(SUBSTR(@row,24,27)),
    unkownno= TRIM(SUBSTR(@row,28,29)),
    latitude= TRIM(SUBSTR(@row,29,34)),
    longitude= TRIM(SUBSTR(@row,35,41)),
    fmdata= TRIM(SUBSTR(@row,42,46)),
    elevation= TRIM(SUBSTR(@row,47,51)),
    placehold= TRIM(SUBSTR(@row,52,56)),
    placehold1= TRIM(SUBSTR(@row,57,60)),
    winddata= TRIM(SUBSTR(@row,61,63)),
    quality= TRIM(SUBSTR(@row,64,64)),
    place3= TRIM(SUBSTR(@row,65,65)),
    place4= TRIM(SUBSTR(@row,66,69)),
    place5= TRIM(SUBSTR(@row,70,70)),
    place6= TRIM(SUBSTR(@row,71,71)),
    place7= TRIM(SUBSTR(@row,72,76)),
    place8= TRIM(SUBSTR(@row,77,77)),
    place9= TRIM(SUBSTR(@row,78,78)),
    visibiltydst= TRIM(SUBSTR(@row,79,84)),
    qualitycode= TRIM(SUBSTR(@row,85,85)),
    place10= TRIM(SUBSTR(@row,86,86)),
    place11= TRIM(SUBSTR(@row,87,87)),
    place12= TRIM(SUBSTR(@row,88,88)),
    temp= TRIM(SUBSTR(@row,88,93)),
    qualitycd2= TRIM(SUBSTR(@row,93,93)),
    dewpoint= TRIM(SUBSTR(@row,94,98)),
    qualitycd4= TRIM(SUBSTR(@row,99,99)),
    atmosprs= TRIM(SUBSTR(@row,100,104)),
    quality8= TRIM(SUBSTR(@row,104,104))
    
;
eof
exit