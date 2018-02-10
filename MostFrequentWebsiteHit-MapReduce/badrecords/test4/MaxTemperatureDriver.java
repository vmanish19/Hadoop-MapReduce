  import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.mapreduce.*;

//Identical to v3 except for v4 mapper
public class MaxTemperatureDriver extends Configured implements Tool {

  @Override
  public int run(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.printf("Usage: %s [generic options] <input> <output>\n",
          getClass().getSimpleName());
      ToolRunner.printGenericCommandUsage(System.err);
      return -1;
    }

    String jobID = args[0];
    Job job = new Job(getConf(), "Max temperature");
    job.setJarByClass(getClass());

    job.setJobName("MT Test 1 mrv");
    job.setNumReduceTasks(12);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setMapperClass(MaxTemperatureMapper.class);
    job.setCombinerClass(MaxTemperatureReducer.class);
    job.setReducerClass(MaxTemperatureReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);


     job.waitForCompletion(true) ;


    Counters counters = job.getCounters();
    long total = counters.findCounter(MaxTemperatureMapper.Temperature.MALFORMED).getValue();
    System.out.println("Bad Records "+total);
 
    Counters counters1 = job.getCounters();
    long total1 = counters1.findCounter(MaxTemperatureMapper.Temperature.INVALIDTEMP).getValue();
    System.out.println("Invalid Temperature " + total1);

    return 0;


  }
 
    public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new MaxTemperatureDriver(), args);

    System.exit(exitCode);
  }
}
