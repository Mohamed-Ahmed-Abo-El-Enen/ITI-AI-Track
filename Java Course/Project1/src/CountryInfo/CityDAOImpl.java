package CountryInfo;
import java.util.*;

public class CityDAOImpl
{
    private List<City> ConvertLinesToListCities(List<List<String>> lines)
    {
        List<City> cityList = new ArrayList<City>();
        try
        {
            for (List<String> line : lines) {
                int id = Integer.parseInt(line.get(0));
                String Name = line.get(1);
                int Population = line.get(2).equals("") ? 0 : Integer.parseInt(line.get(2));
                String countryCode = line.get(3);
                cityList.add(new City(id, Name, Population, countryCode));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return cityList;
    }

    public List<City> ReadCityCSVFile(String filePath)
    {
        List<List<String>> lines = new FileHandler(filePath).ReadCSVFile();
        return ConvertLinesToListCities(lines);
    }
}
