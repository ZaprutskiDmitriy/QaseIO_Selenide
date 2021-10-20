package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    public String user;
    public String password;

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

/*        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // ChromeDriver is just AWFUL because every version or two it breaks unless you pass cryptic arguments
//AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); // https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
*/
    }

    @AfterMethod
    public void afterTest() {
        getWebDriver().quit();
    }
}
