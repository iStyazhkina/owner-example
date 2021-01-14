package service;

import org.aeonbits.owner.ConfigFactory;
import utils.WebConfig;

import java.net.URL;

public class WebService {

    private static WebConfig config = ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());

    public static String getBrowserName() {
       return config.browserName();
    }

    public static String getBrowserVersion() {
        return config.browserVersion();
    }

    public static String getWebDriverVersion() {
        return config.webdriverVersion();
    }

    public static boolean isRemote() {
        return config.isRemote();
    }

    public static URL getRemoteUrl() {
        return config.remoteBrowserUrl();
    }
}
