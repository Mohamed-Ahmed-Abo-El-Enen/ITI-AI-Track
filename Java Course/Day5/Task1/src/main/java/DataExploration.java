import joinery.DataFrame;
import tech.tablesaw.api.Table;
import java.util.Arrays;
import java.util.List;

public class DataExploration
{
    private Table table;
    private DataFrame<Object> dataFrame;

    public DataExploration()
    { }

    public void tablesReadFromCSVFile(String filePath)
    {
        table = new FileHandler().tablesawReadCSVFile(filePath);
    }

    public void tablesPrintTable() {
        System.out.println(table);
    }

    public void joineryReadFromCSVFile(String filePath)
    {
        dataFrame = new FileHandler().joineryReadCSVFile(filePath);
    }

    public void FillDataframeEmptyNumeric()
    {
        dataFrame.numeric().fillna(0);
    }

    public void PrintDataframeColumns()
    {
        System.out.println(dataFrame.columns());
    }

    public void PrintDataframe() {
        System.out.println(dataFrame);
    }

    public void PrintDataframeMean(String correspondingColumn, String[] columnsArray)
    { System.out.println(this.dataFrame.retain(columnsArray).groupBy(correspondingColumn).mean());}

    public void PrintDataframeMax(String correspondingColumn, String[] columnsArray)
    { System.out.println(this.dataFrame.retain(columnsArray).groupBy(correspondingColumn).max());}

    public void PrintDataframeMin(String correspondingColumn, String[] columnsArray)
    { System.out.println(this.dataFrame.retain(columnsArray).groupBy(correspondingColumn).min());}

    public void PrintDataframeStd(String correspondingColumn, String[] columnsArray)
    { System.out.println(this.dataFrame.retain(columnsArray).groupBy(correspondingColumn).stddev());}

    public void PrintDataframeMedian(String correspondingColumn, String[] columnsArray)
    { System.out.println(this.dataFrame.retain(columnsArray).groupBy(correspondingColumn).median());}

    public void GetStatisticalInfo(String correspondingColumn, String[] columns)
    {
        try
        {
            List<String> columnsList = Arrays.asList(columns);
            String[] columnsArray = new String[columnsList.size()];
            columnsArray = columnsList.toArray(columnsArray);

            PrintDataframeMin(correspondingColumn, columnsArray);
            PrintDataframeMax(correspondingColumn, columnsArray);
            PrintDataframeMean(correspondingColumn, columnsArray);
            PrintDataframeMedian(correspondingColumn, columnsArray);
            PrintDataframeStd(correspondingColumn, columnsArray);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
