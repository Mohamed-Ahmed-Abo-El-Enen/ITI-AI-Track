import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.feature.HashingTF;
import org.apache.spark.ml.feature.Tokenizer;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.tuning.CrossValidator;
import org.apache.spark.ml.tuning.CrossValidatorModel;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.ml.Model;

public class ClassificationModel
{
    private Pipeline pipeline;
    private ParamMap[] paramGrid;

    private Tokenizer Tokenizer()
    {
        return new Tokenizer().setInputCol("text").setOutputCol("words");
    }

    private HashingTF HashingTF(Tokenizer tokenizer)
    {
        return new HashingTF().setNumFeatures(20).setInputCol(tokenizer.getOutputCol()).setOutputCol("features");
    }

    private LogisticRegression DefineModel()
    {
        return new LogisticRegression().setMaxIter(10).setRegParam(0.001);
    }

    private Pipeline DefinePipLine()
    {
        Tokenizer tokenizer = Tokenizer();
        HashingTF hashingTF = HashingTF(tokenizer);
        LogisticRegression lr = DefineModel();
        return new Pipeline().setStages(new PipelineStage[] {tokenizer, hashingTF, lr});
    }

    public PipelineModel FitPipLine(Dataset<Row> training)
    {
        Pipeline pipeline = DefinePipLine();
        return pipeline.fit(training);
    }

    private void DefineCrossValPipLine()
    {
        Tokenizer tokenizer = Tokenizer();
        HashingTF hashingTF = HashingTF(tokenizer);
        LogisticRegression lr = DefineModel();

        this.pipeline = new Pipeline().setStages(new PipelineStage[] {tokenizer, hashingTF, lr});

        this.paramGrid = new ParamGridBuilder()
                .addGrid(hashingTF.numFeatures(), new int[] {10, 100, 1000})
                .addGrid(lr.regParam(), new double[] {0.1, 0.01})
                .build();
    }

    public CrossValidatorModel FitCrossValPipLine(Dataset<Row> training)
    {
        this.DefineCrossValPipLine();
        CrossValidator cv = new CrossValidator()
                .setEstimator(this.pipeline)
                .setEvaluator(new MulticlassClassificationEvaluator())
                .setEstimatorParamMaps(this.paramGrid)
                .setNumFolds(2)  // Use 3+ in practice
                .setParallelism(2);  // Evaluate up to 2 parameter settings in parallel
        return cv.fit(training);
    }

    public void Predict(Model Model, Dataset<Row> test) {
        Dataset<Row> predictions = Model.transform(test);
        for (Row r : predictions.select("id", "text", "probability", "prediction").collectAsList())
        {
            System.out.println("(" + r.get(0) + ", " + r.get(1) + ") --> prob=" + r.get(2)
                    + ", prediction=" + r.get(3));
        }
    }
}
