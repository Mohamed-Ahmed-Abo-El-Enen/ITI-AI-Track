package CountryInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler
{
    private String filePath;
    private List<List<String>> Lines;

    FileHandler(String filePath) {
        this.filePath = filePath;
        this.Lines = new LinkedList<>();
    }

    public List<List<String>> getLines() {
        return Lines;
    }

    public List<List<String>> ReadCSVFile() {
        try {
            Thread thread = new Thread(() -> {
                try {

                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        List<String> lineList = Arrays.asList(line.split(","));
                        this.Lines.add(lineList.stream().map(String::strip).collect(Collectors.toList()));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            thread.start();
            thread.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.Lines;
    }
}
