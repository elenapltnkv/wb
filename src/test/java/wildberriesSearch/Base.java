package wildberriesSearch;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Base {


    @BeforeAll
    public static void openPage() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.wildberries.ru/";
        Configuration.pageLoadStrategy= String.valueOf(PageLoadStrategy.EAGER);
        Configuration.remote = "http://45.9.40.101:4445/wd/hub/";

        DesiredCapabilities capabilities =  new DesiredCapabilities();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", false);
        capabilities.setCapability("selenoid:options", selenoidOptions);
        Configuration.browserCapabilities= capabilities;
    }

    @BeforeEach
    public void beforeEach() {
        //baseUrl = "https://www.wildberries.ru/";
        SelenideLogger.addListener("allure", new AllureSelenide());


    }

    @AfterEach
    void addAttachments() {
        Attach.makeScreenshot("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }


}

