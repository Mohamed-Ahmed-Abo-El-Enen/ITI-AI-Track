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

public class YoutubeClassify {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("JavaSimpleTextClassificationPipeline").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        SQLContext jsql = new SQLContext(jsc);

// Prepare training documents, which are labeled.
        Dataset<Row> training = jsql.createDataFrame(Arrays.asList(
                new JavaLabeledDocument(0L, "a b c d e spark", 1),
                new JavaLabeledDocument(1L, "b d", 2),
                new JavaLabeledDocument(2L, "spark f g h", 1),
                new JavaLabeledDocument(3L, "I Move", 2),
                new JavaLabeledDocument(4L, "hadoop mapreduce", 0),
                new JavaLabeledDocument(5L, "hadoop mapreduce", 1),
                new JavaLabeledDocument(6L, "you are dead", 0)
        ), JavaLabeledDocument.class);

// Configure an ML pipeline, which consists of three stages: tokenizer, hashingTF, and lr.
        Tokenizer tokenizer = new Tokenizer()
                .setInputCol("text")
                .setOutputCol("words");
        HashingTF hashingTF = new HashingTF()
                .setNumFeatures(1000)
                .setInputCol(tokenizer.getOutputCol())
                .setOutputCol("features");
        LogisticRegression lr = new LogisticRegression()
                .setMaxIter(10)
                .setRegParam(0.001);
        Pipeline pipeline = new Pipeline()
                .setStages(new PipelineStage[] {tokenizer, hashingTF, lr});

// Fit the pipeline to training documents.
        PipelineModel model = pipeline.fit(training);

// Prepare test documents, which are unlabeled.
        Dataset<Row> test = jsql.createDataFrame(Arrays.asList(
                new JavaDocument(7L, "spark i j k"),
                new JavaDocument(8L, "l m n"),
                new JavaDocument(9L, "spark hadoop spark"),
                new JavaDocument(10L, "apache hadoop"),
                new JavaDocument(11L, "I Move"),
                new JavaDocument(12L, "b c")
        ), JavaDocument.class);

// Make predictions on test documents.
        Dataset<Row> predictions = model.transform(test);
        for (Row r : predictions.select("id", "text", "probability", "prediction").collectAsList()) {
            System.out.println("(" + r.get(0) + ", " + r.get(1) + ") --> prob=" + r.get(2)
                    + ", prediction=" + r.get(3));
        }
    }
}