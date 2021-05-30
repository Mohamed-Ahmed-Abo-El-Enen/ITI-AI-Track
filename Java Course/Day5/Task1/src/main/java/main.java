import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        String datasetPath = "dataset/train.csv";
        DataExploration dataExploration = new DataExploration();
        dataExploration.joineryReadFromCSVFile(datasetPath);
        dataExploration.FillDataframeEmptyNumeric();
        dataExploration.PrintDataframeColumns();
        dataExploration.PrintDataframe();
        String[] columns = {"Survived", "Age", "SibSp", "Parch", "Fare"};
        String correspondingColumn  = "Pclass";

        dataExploration.GetStatisticalInfo(correspondingColumn, columns);
    }
}
