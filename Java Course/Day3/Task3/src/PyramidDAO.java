import java.util.List;

public interface PyramidDAO
{
    public List<Pyramid> getAllPyramid();
    public Pyramid getPyramid(int pyramidIndex);
    public void updatePyramidList(int pyramidIndex, Pyramid pyramid);
    public void deletePyramid(Pyramid pyramid);
    public boolean isExist(Pyramid pyramid);
}
