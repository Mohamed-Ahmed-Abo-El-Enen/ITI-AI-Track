import CountryInfo.*;

import java.util.List;

public class main
{
    public static void main(String args[])
    {
        String countryDatasetPath = "Dataset/Countries.csv";
        List<Country> countryList = new CountryDAOImpl().ReadCountryCSVFile(countryDatasetPath);

        String cityDatasetPath = "Dataset/Cities.csv";
        List<City> cityList = new CityDAOImpl().ReadCityCSVFile(cityDatasetPath);

        CountryIndex countryIndex = new CountryIndex();
        countryIndex.BuildCountryIndex(countryList, cityList);

        countryList.clear();
        cityList.clear();

        countryIndex.GetSortedPopulation();
        countryIndex.GetListOfCountriesPopulation();
        countryIndex.GetAverage();
        countryIndex.GetMaxCountryPopulation();
        countryIndex.GetHighestPopulationCountryCity();
        countryIndex.GetHighestPopulationCapital();
    }
}
