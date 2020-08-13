package pageobjectpattern;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.Zakupy;
import pageobjects.LoginPage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class MyStepdefsZakupy {
    private static WebDriver driver;

    @Given("^otwieramy przegladarke i logujemy sie na konto Antonio Banderasa$")
    public void otwieramyPrzegladarkeILogujemySieNaKontoAntonioBanderasa() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("dtzkdklnudbgvvbzxt1@ttirv.org", "bardzotajnehaslo");
        // driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");

    }

    @When("^wybieramy sweter do zakupu$")
    public void wybieramySweterDoZakupu() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.SearchSweater();
        zakupy.ClickProdukt();
    }

    @Then("^wybieramy rozmiar M$")
    public void wybieramyRozmiarM() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.SetSize();

    }

    @Then("^wybieramy (\\d+) szt$")
    public void wybieramySzt(int arg0) {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.SetQuantity("5");
    }

    @Then("^dodajemy do koszyka$")
    public void dodajemyDoKoszyka() {
        Zakupy zakupy = new Zakupy(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zakupy.ClickAddToCard();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zakupy.ClickContinueShoping();
    }

    @Then("^przechodzimy do checkout$")
    public void przechodzimyDoCheckout() {

        Zakupy zakupy = new Zakupy(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zakupy.ClickContinueShoping();
    }

    @Then("^potwierdzamy adres$")
    public void potwierdzamyAdres() {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickCorrectAddress();
    }

    @Then("^wybieramy metodę odbioru - PrestaShop \"([^\"]*)\"$")
    public void wybieramyMetodęOdbioruPrestaShop(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickShippingMethod();
        zakupy.ClickPrestaShop();

    }

    @Then("^wybieramy metodę płatnosci \"([^\"]*)\"$")
    public void wybieramyMetodęPłatnosci(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickPaymentMethod();
        zakupy.ClickPpayByCheck();
        zakupy.ClickConditions();

    }

    @Then("^klikamy w \"([^\"]*)\"$")
    public void klikamyW(String arg0) throws Throwable {
        Zakupy zakupy = new Zakupy(driver);
        zakupy.ClickLastButton();

    }

    @Then("^robimy screenshota$")
    public void robimyScreenshota() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String filename = now.format(formatter) + "-screenshot.png";
        try {
            FileUtils.copyFile(scrFile, new File("Hania_screenshots/" + filename));
        } catch (IOException e) {
            System.out.println("Nie ma screenshota");
            e.printStackTrace();
        }
    }

    @And("^Zamykamy przeglądarkę$")
    public void zamykamyPrzeglądarkę() {
        driver.quit();
    }


}
