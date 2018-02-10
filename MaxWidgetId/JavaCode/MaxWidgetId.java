
import java.io.IOException;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;

public class MaxWidgetId extends Configured implements Tool {

  public static class MaxWidgetMapper
      extends Mapper<LongWritable, Text, Text, DoubleWritable >  {

    private Widget maxWidget = null;

    public void map(LongWritable k, Text v, Context context) 
     throws IOException, InterruptedException {
      Widget widget = new Widget();
      try {
        widget.parse(v); // Auto-generated: parse all fields from text.
      } catch (ParseError pe) {
        // Got a malformed record. Ignore it.
        return;
      }

      String widgetName = widget.get_widget_name();
      Double price = widget.get_price().doubleValue();
       if (null == widgetName) {
          return;
        }
       else {
          context.write(new Text(widgetName), new DoubleWritable(price));
         }
    }
  }

  public static class MaxWidgetReducer
      extends Reducer<Text, DoubleWritable, Text, DoubleWritable > {

    // There will be a single reduce call with key '0' which gets
    // the max widget from each map task. Pick the max widget from
    // this list.
    public void reduce(Text key, Iterable<DoubleWritable> vals, Context context)
        throws IOException, InterruptedException {
        int count = 0;
        Double price = 0.0;        
        Double average =0.0;
      for (DoubleWritable value : vals) {
	  price = price + value.get();
	  count++;	         
	  } 
	average = price/count;
        Double newAverage = Math.round(average*100.0)/100.0;
        String newKey = "Average price for " + key.toString() + " is :";  
        context.write(new Text(newKey), new DoubleWritable(newAverage));
      
    }
  }

  public int run(String [] args) throws Exception {
    Job job = new Job(getConf());

    job.setJarByClass(MaxWidgetId.class);

    job.setMapperClass(MaxWidgetMapper.class);
    job.setReducerClass(MaxWidgetReducer.class);

    FileInputFormat.addInputPath(job, new Path("widgets"));
    FileOutputFormat.setOutputPath(job, new Path("averagewidgets"));

    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(DoubleWritable.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(DoubleWritable.class);

    job.setNumReduceTasks(1);

    if (!job.waitForCompletion(true)) {
      return 1; // error.
    }

    return 0;
  }

  public static void main(String [] args) throws Exception {
    int ret = ToolRunner.run(new MaxWidgetId(), args);
    System.exit(ret);
  }
}
