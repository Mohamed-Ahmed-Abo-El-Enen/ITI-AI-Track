import java.util.List;

public class main
{
    public static void main(String args[])
    {
        String path = "dataset/pyramids.csv";
        PyramidDAOImpl pyramids = new PyramidDAOImpl();
        pyramids.ReadPyramidCSVFile(path);
        pyramids.PrintPyramids();

        System.out.println("################ Sorted With Height ################");
        pyramids.SortAccordingToHeight(true);
        pyramids.PrintPyramids();

        System.out.println("################ Sites Frequency ################");
        pyramids.PrintSitesFrequency();
    }
}
