  import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
 import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MaxPageReducer
  extends Reducer<Text, Text, Text, Text> {
  public Map<String ,Integer> count = new HashMap<>(); 
 
  @Override
  public void reduce(Text key, Iterable<Text> values,
      Context context)
      throws IOException, InterruptedException {
   
    for  (Text line :values) {
 //   Text line = values.next();
    String value = line.toString();
    int start = value.indexOf('/');
    int end = value.indexOf('.') ;
    String name = value.substring(start,end);
    count.put(name, count.getOrDefault(name ,0) + 1); 
    }
  
   String output = null;
   Integer counter =0;   
   for(Map.Entry<String,Integer> entry : count.entrySet()) {
     if (entry.getValue() > counter) {
        counter = entry.getValue();
        output = entry.getKey();
    }  
   }

    context.write(key, new Text(output));
  }
}
