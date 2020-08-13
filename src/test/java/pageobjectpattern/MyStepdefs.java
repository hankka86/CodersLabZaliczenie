package pageobjectpattern;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.AddressPage;
import pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    private static WebDriver driver;

    @Given("^otwieramy przegladarke i wchodzimy odpowiednią stronę$")
    public void otwieramyPrzegladarkeIWchodzimyOdpowiedniąStronę() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

    }

    @When("^podajemy dane do zalogowania email i password$")
    public void podajemyDaneDoZalogowaniaEmailIPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("dtzkdklnudbgvvbzxt1@ttirv.org", "bardzotajnehaslo");


    }


    @Then("^Uzytkownik jest zalogowany$")
    public void uzytkownikJestZalogowany() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Antonio Banderas", loginPage.getLoggedUsername());
    }

    @When("^przechodzimy do strony z adresmai i klikamy \\+Create New Address$")
    public void przechodzimyDoStronyZAdresmaiIKlikamyZCreateNewAddress() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");

    }

    @Then("^wypełniamy formularz danymi z \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void wypełniamyFormularzDanymiZ(String alias, String address, String zipCode, String city, String country) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        AddressPage addressPage = new AddressPage(driver);
        addressPage.SetAddress(alias, address, zipCode, city, country);
        //throw new PendingException();
    }

    @And("^Sprawdzamy czy dane są poprawne \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void sprawdzamyCzyDaneSąPoprawne(String alias, String address, String zipCode, String city, String country) throws Throwable {
        AddressPage addressPage = new AddressPage(driver);
      /* String costam= "CodersLab\n" +
               "Antonio Banderas\n" +
               "ul.Prosta 51\n" +
               "Warszawa\n" +
               "00-000\n" +
               "United Kingdom\n" +
               "\uE254 Update \uE872 Delete";*/
        String costam = alias + "\n" +
                "Antonio Banderas\n" +
                address + "\n" +
                city + "\n" +
                zipCode + "\n" +
                country + "\n" +
                "\uE254 Update \uE872 Delete";
        Assert.assertEquals(costam, addressPage.getLastAddress(alias));
        // throw new PendingException();
    }


    @And("^Zamykamy przeglądarke$")
    public void zamykamyPrzeglądarke() {
        driver.quit();
    }
}
