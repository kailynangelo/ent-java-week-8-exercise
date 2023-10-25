import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testswapiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://petstore.swagger.io/v2/pet/1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        //ObjectMapper mapper = new ObjectMapper();
//        Planet planet = mapper.readValue(response, Planet.class);
//        String expectedPlanetName = "Tatooine";
//        assertEquals(expectedPlanetName, planet.getName());

        assertEquals("{\"id\":1,\"category\":{\"id\":1,\"name\":\"string\"},\"name\":\"doggie\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":1,\"name\":\"string\"}],\"status\":\"available\"}", response);
    }
}