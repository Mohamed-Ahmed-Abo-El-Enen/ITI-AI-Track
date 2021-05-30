import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class DataManipulation
{
    public static List<TitanicPassenger> getPassengersFromJsonFile(String filePath)
    {
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream(filePath))
        {
            allPassengers = objectMapper.readValue(input, new TypeReference<List<TitanicPassenger>>() {});
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return allPassengers;
    }
}
