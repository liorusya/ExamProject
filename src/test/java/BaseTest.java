import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.ElementsPage;
import pages.HomePage;
import pages.elementsPageTabs.TextBoxTab;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    //оголошуємо змінну /homepage / elements...
    protected HomePage homePage;
    protected ElementsPage elementsPage;
    protected TextBoxTab textBoxTab;

    @Before
    public void setUp() {
        logger.info("---");
        logger.info("-------  " + testName.getMethodName() + "  was started --------\n");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        //create new page object and will work with webDriver(chrome)
        homePage = new HomePage(webDriver);
        elementsPage = new ElementsPage(webDriver);
        textBoxTab = new TextBoxTab(webDriver);

    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            //WebDriverManager.iedriver().setup();
            // in most cases 32bit version is needed
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
        return webDriver;
    }

    @After
    public void tearDown() {
        webDriver.close();
        logger.info("Browser was closed");
        logger.info("-------  " + testName.getMethodName() + "  was finished --------\n");

    }
}
