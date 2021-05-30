package CountryInfo;

public class Country
{
    private String Code;
    private String Name;
    private String Continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;

    Country()
    {
        this.Code = "";
        this.Name = "";
        this.Continent = "";
        this.surfaceArea = 0;
        this.population = 0;
        this.gnp = 0;
        this.capital = 0;
    }

    Country(String Code, String Name, String Continent, double surfaceArea, int population, double gnp, int capital)
    {
        this.Code = Code;
        this.Name = Name;
        this.Continent = Continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return Continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public double getGnp() {
        return gnp;
    }

    public int getCapital() {
        return capital;
    }
}