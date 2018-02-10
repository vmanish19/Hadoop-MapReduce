
# Week-14 Cluster Assignment

## Test 1: Without combiner, without intermediate compression on 1994


![Test1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1.JPG)

**Analysis:**

- As inferred from the image, y-axis is the total time taken to complete job, x-axis is the file formats and different lines show time taken to complete job with different reducer.    
- Here, we have input file of three different format txt, bz2 and gzip. Gzip is not splitable and only one map is created hence job duration with gzip file is more compared
  to bzip and text.
- A bzip2 file, on the other hand is splittable in hadoop - it provides very good compression ratio but from CPU time and performances is not providing optimal results,
  as compression is very CPU consuming.  
- Processing for a text file is faster because of following reason :
- According to textbok page no 30 under data flow section the input txt file is divided into fixed size pieces called input splits,
  create one map for each split and map function for each record in the split. 
- Having many splits means the time taken to process each split is small compared to the time to process the whole input. 
- Because of large number map out is generated. Maper output will partition the data to 8 different reducer which reduce bottle neck on 1 reducer. 
  Also we are using small size file as compared to file in test 7 hence there will be less network congestion while sending map output to reducer.
- Hence processing time for text is less compared to bzip and gzip as we can see from graph.

-----------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 1	

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1%20Reducer1.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1%20reducer%202.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1%20reducer4.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1%20reducer%208.JPG) 

-------------------------------------------
-----------------------------------------

## Test 2: With combiner, with intermediate compression on 1994


![Test2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test2.JPG)

- As inferred from the image, y-axis is the total time taken to complete job, x-axis is the file formats and different lines show time taken to complete job with different reducer.    
- Here, we have run job using combiner and intermediate compression.
- As bandwidth available on the cluster is limited to minimize the data transferred between map and reduce tasks combiner function to be run on the map output, 
  and the combiner function’s output forms the input to the reduce function.
- From below graph we can there is no reducer time because Combiner function run zero, one, or many times should produce the same output from the reducer.
- Because of using compression we get two major benefits it reduces the space needed to store files, and it speeds up data transfer across the network or to or from disk.
- The gzip format uses DEFLATE to store the compressed data here start of each block is not distinguished hence gzip does not support splitting.
- MapReduce will create only one map for gzip due to which merge and shuffle time will be more hence increase job duration with gzip input as compared to txt and bzip2.
- The main benefit of using intermediate compression is it will reduce the network traffic as ouput of map will be in compressed format which will be send across network.
------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test2%201%20Reducer.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%202%202%20Reducer.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%202%204%20Reducer.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test2%208%20Reducer.JPG) 

-------------------------------------------
-----------------------------------------


## Test 3: With combiner, without intermediate compression on 1994


![Test3](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test3.JPG)

Analysis:
- As inferred from the image, y-axis is the total time taken to complete job, x-axis is the file formats and different lines show time taken to complete job with different reducer.    
- Here job with input text run in less time because here we are using combiner which work locally and we are using small size file due to which network traffic will be low.
  on the other hand bzip2 is splittable in hadoop - it provides very good compression ratio but from CPU time and performances is not providing optimal results,
  as compression is very CPU consuming.  
- For Gzip only one map will be created which increase the overhead on merge on suffle process hence job time increased.
- From below graph we can there is no reducer time because Combiner function run zero, one, or many times should produce the same output from the reducer.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test3%20Reducer1.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test3%20Reducer2.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test3%20Reducer4.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test3%20Reducer8.JPG) 

-------------------------------------------
-----------------------------------------

## Test 4: Without combiner, without intermediate compression on 90


![Test4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%204.JPG)

- In this test we are using 90 dataset which have to 2 bad records. 
- Here I have used enum counter which will display number of Invalid Temperature and record on console.
- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- As discussed in test 1 processing for a text file is faster than bzip and gzip file.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%204%201%20Reducer.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%204%20reducer%202.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%204%20Reducer%204.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%204%20reducer%208.JPG) 

-------------------------------------------
-----------------------------------------

## Test 5: With combiner, with intermediate compression on 90


![Test5](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%205.JPG)

- In this test we are using 90 dataset which have to 2 bad records. 
- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- As discussed in test 2 mapreduce will create only one map for gzip due to which job duration get increased as we can see from above graph

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%205%201%20reducer.JPG) 
---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%205%20Reducer%202.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%205%20reducer%204.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%205%20reducer%208.JPG) 

-------------------------------------------
-----------------------------------------
## Test 6: With combiner, without intermediate compression on 90


![Test6](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%206.JPG)

- In this test we are using 90 dataset which have to 2 bad records. 
- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- As discussed in test 3 As we can see from above time taken input text run in less time because here we are using combiner which work locally and
  we are using small size file due to which network traffic will be low.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%206%20reducer1.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%206%20Reducer%202.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%206%20Reducer%204.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test%206%20Reducer%208.JPG) 

-------------------------------------------
-----------------------------------------

## Test 7: Without combiner, without intermediate compression on 80-90


![Test7](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test7.JPG)

- In this test we are using larger dataset with file formats of txt, gzip and bzip and working without combiner and without intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers

- Here the number of map increased to 1375 since the file size increased which increase the Network congestion and hence job with text file input will take more time
  as shown in graph.
- Here bzip2 worked very efficiently because it is splitable and output of the map will be compressed which reduces the network traffic.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![Testr1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test7%20Reducer1.JPG)

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![Test7r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test7%20Reducer2.JPG)

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![Test7r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test7%20Reducer4.JPG)

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![Test7r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test7%20Reducer8.JPG)

-------------------------------------------
-----------------------------------------
## Test 8: With combiner, with intermediate compression on 80-90


![Test8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test8.JPG)

- In this test we are using larger dataset with file formats of txt and bzip and working with combiner and with intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers

- Here job with input text run in less time because here we are using combiner which work locally and the ouput of map is in compressed which reduce network traffic.
  on the other hand bzip2 is splittable in hadoop - it provides very good compression ratio but from CPU time and performances is not providing optimal results,
  as compression is very CPU consuming.  
- For Gzip only one map will be created hence job time increased.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test8%20Reducer1.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test8%20Reducer2.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test8%20Reducer4.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test8%20Reducer8.JPG) 

-------------------------------------------
-----------------------------------------

## Test 9: With combiner, without intermediate compression on 80-90


![Test9](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test9.JPG)

- In this test we are using larger dataset with file formats of txt and bzip and working with combiner and with intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers

- Here job with input bzip2 run in less time because here we are using combiner which work locally and the ouput of map is already compressed we don't need to
  compress the output of map which increase cpu efficiency and reduce network traffic. 
------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test9%20Reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test9%20Reducer2.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test9%20Reducer4.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test9%20Reducer8.JPG) 


-------------------------------------------
-----------------------------------------
## Test 10: Without combiner, without intermediate compression on 80-90


![Test10](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test10.JPG)

- In this test we are using file formats of txt working without combiner and without intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 256 due to which less input split will be created which in turn create only 776 map.
- As we can see from the graph reducer with 8 configuration works well eventough on large file because the input split in decreased and hence
  network traffic is less.
------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test10%20Reducer%201.JPG) 

---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test10%20Reducer%202.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test10%20Reducer%204.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test10%20Reducer%208.JPG) 


-------------------------------------------
-----------------------------------------
## Test 11: With combiner, with intermediate compression on 80-90


![Test11](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test11.JPG)

- In this test we are using file formats of txt working with combiner and with intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 256 due to which less input split will be created which in turn create only 776 map.
- As we can see from the graph reducer with 1 configuration works because output of map will be compressed output and combiner will filter the data
  the data locally input and hence network traffic is less.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test1%20Reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test11%20reducer%202.JPG) 

-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test11%20reducer%204.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test11%20reducer%208.JPG) 


-------------------------------------------
-----------------------------------------
## Test 12: With combiner, without intermediate compression on 80-90


![Test12](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/test12.JPG)

- In this test we are using file formats of txt working without combiner and without intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 256 due to which less input split will be created which in turn create only 776 map.
- Since we are using combiner data sorting will be done locally.
- As we can see from the graph reducer with 4 configuration works well because with there was no overhead map to partition the data and send it to
  all 8 reducer which increased the network traffic.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test12%20reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test12%20reducer2.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test12%20reducer4.JPG) 

----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8


![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test12%20reducer8.JPG) 

-------------------------------------------
-----------------------------------------
## Test 13:Without combiner, without intermediate compression


![Test13](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test13.JPG)

- In this test we are using file formats of txt working without combiner and without intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 512 due to which less input split will be created but now map task will run for longer time as we can see from below graph.
- As we can see from the graph reducer with 4 configuration works well because with 8 reducer there was a overhead for map to create partition for all 8 reducer hence
  increase network traffic.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test13%20reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test13%20reducer2.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test13%20reducer4.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test13%20reducer8.JPG) 


-------------------------------------------
-----------------------------------------
## Test 14:With combiner, with intermediate compression - 80-90 -512 


![Test14](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test14.JPG)

- In this test we are using file formats of txt working with combiner and with intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 512 due to which less input split will be created but now map task will run for longer time as we can see from below graph.
- As we can see from the graph reducer with 8 configuration works well because with output from the map will be compressed format which will be very less data tranfer over
  network to reducer.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test14%20reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test14%20reducer2.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test14%20reducer14.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test14%20reducer8.JPG) 

-------------------------------------------
-----------------------------------------
## Test 15 : With combiner, without intermediate compression


![Test15](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test15.JPG)

- In this test we are using file formats of txt working with combiner and with intermediate compression.

- As inferred from the image, y-axis is the duration, x-axis is the file formats and different lines show different reducers
.    
- Here, we have increased the block size of data to 512 due to which less input split will be created but now map task will run for longer time and shuffle time will increase
  as we can see from below graph.
- As we can see from the graph reducer with 1 configuration works well because with output from the map will not be in compressed format which will increase the large file tranfer over
  network to reducer. But with only one reducer map output need not to be partioned to send it to single reducer.

------------------
#### Map, Shuffle, Merger and Reduce time - Reducer 1

![r1](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test15%20reducer1.JPG) 


---------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 2

![r2](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test15%20reducer2.JPG) 


-------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 4

![r4](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test15%20reducer%204.JPG) 


----------------------------------------------------------

#### Map, Shuffle, Merger and Reduce time - Reducer 8

![r8](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/Test15%20reducer%208.JPG) 


-------------------------------------------
-----------------------------------------
## Test 16 : Web Server Log

![Test16](https://github.com/illinoistech-itm/mvishwakarma/blob/master/ITMD-521/Week-14/image/test16.JPG)

- Based on above graph and checking the input file size for web log. I will choose without compression and without combiner mode because of following reason :
- As input file is in text format more number of map will be create based on input splits which will work parallely on input file.
- Here the size of web log file is less as compared to 80-90 file. Hence map output will not create much network traffic.
- Even tough intermediate compression give very good compression ratio but from CPU time and performances is not providing optimal results,
  as compression is very CPU consuming.  
- I have used reducer 4 because map output need not to be partioned to send it to 8 reducer which will increase the network congestion on network.

-------------------------------------------
-----------------------------------------
## Test 17 : Conclusion:

- Based on above graph result we should use following configuration on certain conditions:
- Intermediate compression: When the file size is very large because as compression is very CPU consuming. 
- Combiner: Minimize the data transferred between map and reduce tasks. Note : combiner function is an optimization 
            Calling the combiner function zero, one, or many times should produce the same output from the reducer.
- Block Size: With fewer blocks, the file may potentially be stored on fewer nodes in total; this can reduce total throughput for parallel access, 
             and make it more difficult for the MapReduce scheduler to schedule data-local tasks.
- Number of Reducers: We should increase the number of reducer only when there is a large ouput from many map and there is a bottle neck on one reducer.
