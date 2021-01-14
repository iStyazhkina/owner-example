package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import service.WebService;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@Tag("web")
class WebTestExample {

    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = WebService.getBrowserName();
        Configuration.browserVersion = WebService.getBrowserVersion();
        if(WebService.isRemote()) {
            Configuration.remote = String.valueOf(WebService.getRemoteUrl());
        }
    }

    @Test
    void searchTest() {
        Selenide.open("https://yandex.ru");
        $(".input__control").setValue("Новосибирск").pressEnter();
        $$(".serp-item")
                .get(0).shouldHave(Condition.text("Новосибирск"));
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }
}
