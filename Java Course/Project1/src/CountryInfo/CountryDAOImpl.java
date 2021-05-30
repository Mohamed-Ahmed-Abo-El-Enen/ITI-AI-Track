package CountryInfo;
import java.util.*;

public class CountryDAOImpl
{
    private List<Country> ConvertLinesToListCountries(List<List<String>> lines)
    {
        List<Country> countryList = new ArrayList<Country>();
        try {
            for (List<String> line : lines) {
                String Code = line.get(0);
                String Name = line.get(1);
                String Continent = line.get(2);
                double surfaceArea = Float.parseFloat(line.get(3));
                int Population = (int) Float.parseFloat(line.get(4));
                double gnp = Double.parseDouble(line.get(5));
                int Capital = Integer.parseInt(line.get(6));
                countryList.add(new Country(Code, Name, Continent, surfaceArea, Population, gnp, Capital));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return countryList;
    }

    public List<Country> ReadCountryCSVFile(String filePath)
    {
        List<List<String>> lines = new FileHandler(filePath).ReadCSVFile();
        return ConvertLinesToListCountries(lines);
    }
}
