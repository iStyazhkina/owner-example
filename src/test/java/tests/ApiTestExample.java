package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import retrofit.WeatherClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import service.ApiService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("api")
public class ApiTestExample {
    private static WeatherClient weatherClient;

    @BeforeAll
    static void prepare() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(ApiService.getBaseUrl())
                .build();
        weatherClient = retrofit.create(WeatherClient.class);
    }

    @Test
    void getWeatherTest() throws IOException {
        Response<Object> california = weatherClient.getWeather("California", ApiService.getToken()).execute();
        String responseBody = california.body().toString();
        assertTrue(responseBody.contains("coord={lon=-76.5074, lat=38.3004}"));
        assertTrue(responseBody.contains("main={temp="));
        assertEquals(200, california.code());
    }
}
