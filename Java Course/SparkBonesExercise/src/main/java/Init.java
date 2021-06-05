import java.util.Arrays;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.feature.HashingTF;
import org.apache.spark.ml.feature.Tokenizer;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class Init
{
    public static JavaSparkContext InitJavaSparkContext(String appName)
    {
        SparkConf conf = new SparkConf().setAppName(appName).setMaster("local[*]");
        return new JavaSparkContext(conf);
    }

    public static SQLContext InitSQLContext(JavaSparkContext javaSparkContext)
    {
        return new SQLContext(javaSparkContext);
    }
}
