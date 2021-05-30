import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        String jsonDatasetPath = "src/dataset/titanic_csv.json";

        List<TitanicPassenger> passengerList = DataManipulation.getPassengersFromJsonFile(jsonDatasetPath);

        DataVisualization dataVisualization = new DataVisualization();

        //dataVisualization.GraphPassengerAges(passengerList);
        //dataVisualization.GraphPassengerClass(passengerList);

        dataVisualization.GraphPassengerSurvived(passengerList);

        dataVisualization.GraphPassengerSurvivedGender(passengerList);
    }
}
