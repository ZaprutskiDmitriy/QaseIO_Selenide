package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @BeforeMethod
    public void setup() {

//        Implicitly Wait
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 60000;
//        Browser type
        Configuration.browser = "chrome";
//        Base URL
        Configuration.baseUrl = "https://app.qase.io/";
//        Maximized
        Configuration.startMaximized = true;
//        Run chrome in background
        Configuration.headless = false;
//        All clicks using JS
        Configuration.clickViaJs = false;

    }

    @AfterMethod
    public void afterTest() {
        getWebDriver().quit();
    }
}
