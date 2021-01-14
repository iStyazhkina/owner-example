package service;

import org.aeonbits.owner.ConfigFactory;
import utils.ApiConfig;

import java.net.URL;

public class ApiService {

    private static ApiConfig config = ConfigFactory.newInstance().create(ApiConfig .class, System.getProperties());

    public static URL getBaseUrl() {
        return config.baseUrl();
    }

    public static String getToken() {
        return config.token();
    }

}
