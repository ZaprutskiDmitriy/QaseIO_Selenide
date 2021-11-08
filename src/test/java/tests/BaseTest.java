package tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public String user;
    public String password;
    public ProjectAdapter projectAdapter;
    public SuiteAdapter suiteAdapter;
    public CaseAdapter caseAdapter;

    @BeforeMethod
    public void setup() {
//        Implicitly Wait
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 60000;
//        Browser type
        Configuration.browser = "chrome";
//        Base URL
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL",
                PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER",
                PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASS",
                PropertyReader.getProperty("qase.pass"));
//        Maximized
        Configuration.startMaximized = true;
//        Run chrome in background
        Configuration.headless = false;
//        All clicks using JS
        Configuration.clickViaJs = false;

        projectAdapter = new ProjectAdapter();
        suiteAdapter = new SuiteAdapter();
        caseAdapter = new CaseAdapter();
    }

/*
    @AfterMethod
    public void afterTest() {
        getWebDriver().quit();
    }
*/
}


