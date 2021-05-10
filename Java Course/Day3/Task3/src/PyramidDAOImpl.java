import java.util.*;

public class PyramidDAOImpl implements PyramidDAO
{
    private  List<Pyramid> pyramids;

    private void ConvertLinesToListPyramids(List<List<String>> lines)
    {
        for (List<String> line: lines)
        {
            String Pharaoh = line.get(0);
            String modernName = line.get(2);
            String Site = line.get(4);
            float Height = line.get(7).equals("") ? 0 : Float.parseFloat(line.get(7));

            this.pyramids.add(new Pyramid(Pharaoh, modernName, Site, Height));
        }
    }

    PyramidDAOImpl()
    {
        pyramids = new ArrayList<Pyramid>();
    }

    public void ReadPyramidCSVFile(String filePath)
    {
        List<List<String>> lines = new FileHandler(filePath).ReadCSVFile();
        ConvertLinesToListPyramids(lines);
    }

    @Override
    public List<Pyramid> getAllPyramid() {
        return this.pyramids;
    }

    @Override
    public Pyramid getPyramid(int pyramidIndex) {
        return this.pyramids.get(pyramidIndex);
    }

    @Override
    public void updatePyramidList(int pyramidIndex, Pyramid pyramid) {
        this.pyramids.set(pyramidIndex, pyramid);
    }

    @Override
    public void deletePyramid(Pyramid pyramid) {
        this.pyramids.remove(pyramid);
    }

    @Override
    public boolean isExist(Pyramid pyramid) {
        for (Pyramid item : this.pyramids)
        {
            if(!item.getPharaoh().equals(pyramid.getPharaoh()))
                continue;

            if(!item.getModernName().equals(pyramid.getModernName()))
                continue;

            if(!item.getSite().equals(pyramid.getSite()))
                continue;

            if(!(item.getHeight() == pyramid.getHeight()))
                continue;

            return true;
        }
        return false;
    }

    void SortAccordingToHeight(boolean Ascending)
    {
        if(Ascending)
            this.pyramids.sort((o1, o2) -> Float.compare(o1.getHeight(), o2.getHeight()));
        else {
            this.pyramids.sort((o1, o2) -> Float.compare(o2.getHeight(), o1.getHeight()));
        }
    }

    public void PrintPyramids()
    {
        for (Pyramid item : this.pyramids)
        {
           item.PrintPyramid();
        }
    }

    private Map<String, String> CreateSitesFrequency()
    {
        Map<String, String> sitesFrequency = new HashMap<>();
        try {


            for (Pyramid item : this.pyramids) {
                if (sitesFrequency.containsKey(item.getSite())) {
                    String value = String.valueOf(Integer.parseInt(sitesFrequency.get(item.getSite())) + 1);
                    sitesFrequency.put(item.getSite(), value);
                } else {
                    sitesFrequency.put(item.getSite(), "1");
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return sitesFrequency;
    }

    public void PrintSitesFrequency()
    {
        Map<String, String> sitesFrequency = CreateSitesFrequency();
        sitesFrequency.forEach((key, value) -> System.out.println("Key = "+key+", Value = "+value));
    }
}
