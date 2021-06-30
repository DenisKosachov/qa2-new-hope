package requesters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherRespons;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String POSTFIX = "&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherRespons getWeatherData(long id) throws JsonProcessingException {
        String url = PREFIX + id + POSTFIX;

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WeatherRespons.class);
    }
}
