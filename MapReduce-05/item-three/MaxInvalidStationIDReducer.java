// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.*;
import java.text.DecimalFormat;

public class MaxInvalidStationIDReducer
  extends Reducer<Text, IntWritable, Text, Text> {

  private int frequent =0;  
  private ArrayList<String> temp = new ArrayList<>(); 
  private int recordCount = 0;  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
                     Context context)
      throws IOException, InterruptedException {

    int count = 0;
    
       for (IntWritable value : values) {
          
	  if (value.get() == 9999){
             count++;
          }
        }
 
      if (count >frequent) {
	   frequent = count;
	   temp.add(key.toString());

      }
      recordCount += count;   
   }

@Override
public void cleanup(Context context)
    throws IOException, InterruptedException {
  
   String st = temp.get(temp.size()-1);
   double percent = ((double)frequent/recordCount) * 100  ;
   String output = String.valueOf(frequent) + "  " + new DecimalFormat("#.##").format(percent) +"%";
   context.write(new Text(st), new Text(output));
  }
}






// ^^ MaxTemperatureReducer
