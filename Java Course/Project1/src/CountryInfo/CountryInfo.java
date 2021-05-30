package CountryInfo;
import java.util.Comparator;
import java.util.List;

public class CountryInfo
{
    private String Name;
    private String Continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;

    private List<City> cityList;

    CountryInfo( String Name, String Continent, double surfaceArea, int population, double gnp, int capital, List<City> cityList)
    {
        this.Name = Name;
        this.Continent = Continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
        this.cityList = cityList;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return Continent;
    }

    public int getPopulation() {
        return population;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getGnp() {
        return gnp;
    }

    public int getCapital() {
        return capital;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void GetCountryMaxPopulationCity()
    {
        System.out.println("Country Name: "+this.getName());
        if (this.getCityList().size() == 0)
        {
            System.out.println("No city with no population");
            return;
        }
        City maxCity = this.getCityList().stream().max(Comparator.comparingInt(City::getPopulation)).get();
        System.out.println("City "+maxCity.getName()+" with population = "+maxCity.getPopulation());
    }

    public int GetCountryCapitalPopulation()
    {
        City city = getCityList().stream().filter(v -> this.getCapital() == v.getId()).findAny().orElse(null);
        if (city != null)
            return city.getPopulation();
        return 0;
    }

}
