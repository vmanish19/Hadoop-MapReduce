 import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.net.*;
import java.io.*;

public class MaxPageMapper
  extends Mapper<LongWritable, Text, Text, Text> {

  private static final int MISSING = 9999;
  private static final String sym = "#"; 
  private final static IntWritable one = new IntWritable(1);
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String [] st = line.split("\\s+");
    if (! st[0].contains("#")){		
       String dat = st[4];
       int status = Integer.parseInt(st[10]); 
       if (dat.contains(".php") || dat.contains(".html")){
          if ( ! (dat.contains("index.php") || dat.contains("index.html") || dat.contains("xmlrpc.php"))) { 
             if (status ==200) {
                if (st[3].equals("GET")) { 
                  context.write(new Text(st[0].substring(0,7)), new Text(st[4]) );
             
                }
            }
          }   
        }	
     }
  }
}
