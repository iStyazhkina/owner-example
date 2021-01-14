package utils;

import org.aeonbits.owner.Config;
import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:~/example.api.properties"
})
public interface ApiConfig extends Config {

    @Key("api.baseUrl")
    @DefaultValue("https://api.openweathermap.org/data/2.5/")
    URL baseUrl();

    @Key("apiToken")
    String token();


}
