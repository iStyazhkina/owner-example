package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import service.WebService;

import java.net.URL;
import java.util.function.Supplier;


public class WebDriverProvider implements Supplier<WebDriver> {

    @Override
    public WebDriver get() {
        if(WebService.isRemote()) {
            return chooseRemoteBrowser(WebService.getBrowserName());
        }
        return chooseLocalBrowser(WebService.getBrowserName(), WebService.getBrowserVersion(), WebService.getWebDriverVersion());
    }

    private WebDriver chooseLocalBrowser(String browserName, String browserVersion, String driverVersion) {
        switch (browserName) {
            case "CHROME":
                WebDriverManager.chromedriver().browserVersion(browserVersion).driverVersion(driverVersion).setup();
                return new ChromeDriver();
            case "OPERA":
                WebDriverManager.operadriver().browserVersion(browserVersion).driverVersion(driverVersion).setup();
                return new OperaDriver();
            default:
                throw new IllegalArgumentException("This browser is not supported");
        }
    }

    private WebDriver chooseRemoteBrowser(String browserName) {
        URL remoteUrl = WebService.getRemoteUrl();
        switch (browserName) {
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("enableVNC", true);
                return new RemoteWebDriver(remoteUrl, chromeOptions);
            case "OPERA":
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setCapability("enableVNC", true);
                return new RemoteWebDriver(remoteUrl, operaOptions);
            default:
                throw new IllegalArgumentException("This browser is not supported");
        }
    }
}
