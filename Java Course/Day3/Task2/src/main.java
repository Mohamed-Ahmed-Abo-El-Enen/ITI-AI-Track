import java.util.List;

public class main
{
    public static void main(String[] args)
    {
        String filePath = "dataset/pyramids.csv";

        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV(filePath);

        int i = 0;
        for(Pyramid p: pyramids)
        {
            System.out.println("#"+(i++)+p);
        }
        
    }
}
