import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO
{
    PyramidCSVDAO()
    {}

    public List<Pyramid> readPyramidsFromCSV(String filePath)
    {
        List<Pyramid> pyramids = new ArrayList<>();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                pyramids.add(createPyramid(line.split(",")));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return pyramids;
    }

    public Pyramid createPyramid(String[] metadata)
    {
        String Pharaoh = metadata[0];
        String modernName = metadata[2];
        String Site = metadata[4];
        float Height = metadata[7].isEmpty() ? 0 : Float.parseFloat(metadata[7]);
        //System.out.println(Pharaoh+"--"+modernName+"--"+Site+"--"+Height);

        return new Pyramid(Pharaoh, modernName, Site, Height);
    }
}
