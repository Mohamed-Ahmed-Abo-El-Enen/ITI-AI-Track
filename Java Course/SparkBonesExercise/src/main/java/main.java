import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.tuning.CrossValidatorModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        String appName = "YoutubeClassify";
        String filePath = "src/main/resources/dataset/USvideos.csv";
        int intLabelColIndex=4;
        int featureColIndex=6;

        JavaSparkContext javaSparkContext = Init.InitJavaSparkContext(appName);
        SQLContext sqlContext = Init.InitSQLContext(javaSparkContext);

        DatasetManipulation datasetManipulation = new DatasetManipulation();
        JavaRDD<String> videos = datasetManipulation.ReadCsvFile(javaSparkContext, filePath);

        List<JavaLabeledDocument> documentList = datasetManipulation.ExtractIndexColumnsAsFeatures(videos, intLabelColIndex, featureColIndex);
        Dataset<Row> dataset = sqlContext.createDataFrame(documentList, JavaLabeledDocument.class);

        dataset = dataset.limit(10);
        Dataset<Row>[] splits = datasetManipulation.GetTrainingAndTestDataset(dataset, 0.2f);
        Dataset<Row> trainingData = splits[0];
        Dataset<Row> testData = splits[1];

        ClassificationModel classificationModel = new ClassificationModel();
        //PipelineModel modelPipeline = classificationModel.FitPipLine(trainingData);
        //classificationModel.Predict(modelPipeline, testData);

        CrossValidatorModel modelCVPipeline = classificationModel.FitCrossValPipLine(trainingData);
        classificationModel.Predict(modelCVPipeline, testData);
    }
}
