import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleRead
{
    private List<String> lines;
    private String stoppingWord = "stop";

    ConsoleRead()
    {
        this.lines = new ArrayList<>();
    }

    public List<String> getLines()
    {
        return lines;
    }

    public void PrintStoppingKeyword()
    {
        System.out.println("Your Stopping Keyword is : "+ this.stoppingWord);
    }

    private boolean StopReading(String line)
    {
        if(line.toLowerCase().equals(this.stoppingWord))
            return true;

        this.lines.add(line);
        return false;
    }

    public boolean Reading()
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter data: ");
            String line = bufferedReader.readLine();
            return StopReading(line);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return true;
    }
}
