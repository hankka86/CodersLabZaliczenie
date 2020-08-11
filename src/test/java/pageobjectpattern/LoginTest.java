package pageobjectpattern;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
       // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }
    @Test
    public void testLoginWithProperCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
       // loginPage = new LoginPage(driver);
        //Thread.sleep(2000);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
        Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
    }
    @After
    public void tearDown() {
     //   driver.quit();
    }
}