package CountryInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CountryIndex
{
    private HashMap<String, CountryInfo> countryDictionary;
    public CountryIndex()
    {
        countryDictionary = new HashMap<>();
    }

    public HashMap<String, CountryInfo> getCountryDictionary() {
        return countryDictionary;
    }

    public void BuildCountryIndex(List<Country> countryList, List<City> cityList)
    {
        for (Country country: countryList)
        {
            this.countryDictionary.put(country.getCode(), new CountryInfo(country.getName(),
                    country.getContinent(),
                    country.getSurfaceArea(),
                    country.getPopulation(),
                    country.getGnp(),
                    country.getCapital(),
                    cityList.stream().filter(c-> c.getCountryCode().equals(country.getCode())).toList()));
        }
    }

    public String GetUserCountryCode()
    {
        String readLine="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            readLine=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }

    public void GetHighestPopulationCountryCity()
    {
        this.countryDictionary.values().forEach(CountryInfo::GetCountryMaxPopulationCity);
    }

    public void GetHighestPopulationCapital()
    {
        String countryKey = Collections.max(this.countryDictionary.entrySet(), Comparator.comparingInt(entry -> entry.getValue().GetCountryCapitalPopulation())).getKey();
        System.out.println(this.countryDictionary.get(countryKey).getName() + " is the country and its capital " +
                this.countryDictionary.get(countryKey).getCityList().stream().filter(x->x.getId()==this.countryDictionary.get(countryKey).getCapital()).findFirst().get().getName() + " with max population : " +
                this.countryDictionary.get(countryKey).getCityList().stream().filter(x->x.getId()==this.countryDictionary.get(countryKey).getCapital()).findFirst().get().getPopulation());
    }

    public void GetSortedPopulation()
    {
        List<City>sortedCities= getCountryDictionary().get(GetUserCountryCode()).getCityList().stream().sorted(Comparator.comparingInt(City::getPopulation).reversed()).collect(Collectors.toList());
        for (City i:sortedCities)System.out.println(i.getName()+"  :"+i.getPopulation());
    }

    public void GetListOfCountriesPopulation()
    {
        this.countryDictionary.values().forEach(v -> System.out.println(v.getName() + "  :" + v.getPopulation()));
    }

    public  void GetAverage()
    {
        Double av= this.countryDictionary.values().stream().mapToDouble(CountryInfo::getPopulation).average().getAsDouble();
        System.out.println(av);
    }

    public void GetMaxCountryPopulation()
    {
        CountryInfo countryInfo = Collections.max(this.countryDictionary.entrySet(), Comparator.comparingInt(entry -> entry.getValue().getPopulation())).getValue();
        System.out.println(countryInfo.getName()+"   :"+countryInfo.getPopulation());
    }
}
