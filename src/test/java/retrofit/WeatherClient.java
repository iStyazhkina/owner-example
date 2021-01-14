package retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WeatherClient {


    @GET("weather?")
    Call<Object> getWeather (@Query("q") String city,
                        @Query("appid") String apiKey);

}
