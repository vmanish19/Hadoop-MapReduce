// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxVisibilityReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {

    int maxHighVisibilty = Integer.MIN_VALUE;
    for (IntWritable value : values) {
      maxHighVisibilty = Math.max(maxHighVisibilty, value.get());
    }
    context.write(key, new IntWritable(maxHighVisibilty));
  }
}



// ^^ MaxTemperatureReducer
