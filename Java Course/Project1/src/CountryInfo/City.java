package CountryInfo;

public class City
{
    private int id;
    private String Name;
    private int population;
    private String countryCode;

    City()
    {
        this.id = 0;
        this.Name = "";
        this.population = 0;
        this.countryCode = "";
    }

    City(int id, String Name,  int population, String countryCode)
    {
        this.id = id;
        this.Name = Name;
        this.population = population;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }
}