package utils;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:web.${environment}.properties"
})
public interface WebConfig extends Config {

    @Key("web.browser.name")
    @DefaultValue("CHROME")
    String browserName();

    @Key("web.browser.version")
    @DefaultValue("86")
    String browserVersion();

    @Key("web.driver.version")
    @DefaultValue("86.0.4240.22")
    String webdriverVersion();

    @Key("web.isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("web.remote.url")
    URL remoteBrowserUrl();
}
