import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class FileHandler
{
    FileHandler()
    {}

    void WriteLines(List<String> lines)
    {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            for (String line : lines)
            {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
