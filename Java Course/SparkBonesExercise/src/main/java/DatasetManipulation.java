import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import javax.swing.plaf.PanelUI;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatasetManipulation
{
    private static final String COMMA_DELIMITER = ",";
    private static final String LAMBDA_DELIMITER = "|";
    private List<JavaLabeledDocument> sampleList;
    private long numberSamples;

    public DatasetManipulation()
    {
        this.sampleList = new ArrayList<>();
        this.numberSamples = 1L;
    }

    public JavaRDD<String> ReadCsvFile(JavaSparkContext sparkContext, String file_path)
    {
        return sparkContext.textFile(file_path);
    }

    private String SampleFeaturesPreProcessing(String Features)
    {
        Features = Features.toLowerCase();
        Features = Features.replace("\"", "");
        Features = Features.replace(LAMBDA_DELIMITER, " ");
        return Features;
    }

    public boolean tryParseInt(String value) {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    private void ExtractColumnWithIndex(List<List<String>> videoLineList, int intLabelColIndex, int featureColIndex)
    {
        for (List<String> Line: videoLineList.subList(1, videoLineList.size()))
        {
            if(Line.size()<intLabelColIndex || Line.size()<featureColIndex)
                continue;

            if (!this.tryParseInt(Line.get(intLabelColIndex)))
                continue;

            String Features = this.SampleFeaturesPreProcessing(Line.get(featureColIndex));
            int Label = Integer.parseInt(Line.get(intLabelColIndex));

            this.sampleList.add(new JavaLabeledDocument(this.numberSamples, Features, Label));
            numberSamples += 1L;
        }
    }

    public static String ReadLine(String videoLine) {
        try {
            return videoLine.split("\n")[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }

    }

    public List<JavaLabeledDocument> ExtractIndexColumnsAsFeatures(JavaRDD<String> videos, int intLabelColIndex, int featureColIndex)
    {
        JavaRDD<String> lineList = videos.map(DatasetManipulation::ReadLine);
        List<List<String>> videoLinesList = lineList.map(x -> Arrays.asList(x.split(COMMA_DELIMITER))).collect();
        this.ExtractColumnWithIndex(videoLinesList, intLabelColIndex, featureColIndex);
        return this.sampleList;
    }

    public Dataset<Row>[] GetTrainingAndTestDataset(Dataset<Row> dataset, float test_size)
    {
        return dataset.randomSplit(new double[]{1-test_size, test_size});
    }
}
