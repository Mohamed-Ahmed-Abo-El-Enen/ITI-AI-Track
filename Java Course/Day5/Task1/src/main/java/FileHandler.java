import joinery.DataFrame;
import tech.tablesaw.api.Table;
import java.io.IOException;

public class FileHandler
{
    public Table tablesawReadCSVFile(String filePath)
    {
        try
        {
            return Table.read().csv(filePath);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public DataFrame<Object> joineryReadCSVFile(String filePath)
    {
        try
        {
            return DataFrame.readCsv(filePath);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
