package stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Weather;
import model.WeatherRespons;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherRespons respons;

    @Given("city ID: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        respons = requester.getWeatherData(cityId);
    }

    @Then("coordinates are:")
    public void check_coords(Map<String, Double> coords) {
        Assertions.assertEquals(coords.get("lon"), respons.getCoord().getLon(), "Incorrect Coord lon");
        Assertions.assertEquals(coords.get("lat"), respons.getCoord().getLat(), "Incorrect Coord lat");
    }

    @Then("sys is")
    public void check_sys(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("type")), respons.getSys().getType(), "Wrong Type");
        Assertions.assertEquals(Long.parseLong(params.get("id")), respons.getSys().getId(), "Wrong ID");
        Assertions.assertEquals(Double.parseDouble(params.get("message")), respons.getSys().getMessage(), "Wrong Message");
        Assertions.assertEquals(params.get("country"), respons.getSys().getCountry(), "Wrong Country");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), respons.getSys().getSunrise(), "Wrong Sunrise");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), respons.getSys().getSunset(), "Wrong Sunset");

        LocalDate date = Instant.ofEpochSecond(respons.getSys().getSunrise()).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(date);

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(respons.getSys().getSunrise()), ZoneId.systemDefault());
        System.out.println(dateTime);
    }

    @Then("weathers are:")
    public void check_weathers(DataTable dataTable) {
        List<Map<String, String>> weathers = dataTable.asMaps();

        Assertions.assertEquals(weathers.size(), respons.getWeathers().size(), "Wrong Size");

        for (int i = 0; i < weathers.size(); i++) {
            Map<String, String> expectedWeather = weathers.get(i);
            Weather actualWeather = respons.getWeathers().get(i);

            Assertions.assertEquals(Long.parseLong(expectedWeather.get("id")), actualWeather.getId(), "Wrong Id");
            Assertions.assertEquals(expectedWeather.get("main"), actualWeather.getMain(), "Wrong Main");
            Assertions.assertEquals(expectedWeather.get("description"), actualWeather.getDescription(), "Wrong Description");
            Assertions.assertEquals(expectedWeather.get("icon"), actualWeather.getIcon(), "Wrong Icon");
        }
    }
}