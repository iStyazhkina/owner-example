package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverProvider;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
class WebTestExample {

    private static WebDriver webDriver;

    @BeforeAll
    static void setup() {
        webDriver = new WebDriverProvider().get();
    }

    @Test
    void searchTest() {
        System.out.println(System.getProperty("web.driver.version"));
        Selenide.using(webDriver, () -> {
            open("https://yandex.ru");
            $(".input__control").setValue("Новосибирск").pressEnter();
            $$(".serp-item")
                    .get(0).shouldHave(Condition.text("Новосибирск"));
        });
    }

    @AfterEach
    void closeBrowser() {
        webDriver.close();
    }
}
