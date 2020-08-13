package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Zakupy {
    private static WebDriver driver;

    public Zakupy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//input[@class='ui-autocomplete-input']"))
    private WebElement szukanie;

    public void SearchSweater() {
        szukanie.clear();
        szukanie.sendKeys("Hummingbird printed sweater");

    }


    @FindBy(xpath = ("//article[@data-id-product='2']"))
    private WebElement produkt;

    public void ClickProdukt() {
        produkt.click();
    }

    @FindBy(xpath = ("//select[@data-product-attribute='1']"))
    private WebElement rozmiar;

    public void SetSize() {

        Select roleSelect = new Select(rozmiar);
        roleSelect.selectByVisibleText("M");
    }

    @FindBy(xpath = ("//input[@id='quantity_wanted']"))
    private WebElement ilosc;

    public void SetQuantity(String x) {
        ilosc.clear();
        ilosc.sendKeys(x);
    }

    @FindBy(xpath = ("//button[@data-button-action=\"add-to-cart\"]"))
    private WebElement koszyk;

    public void ClickAddToCard() {
        koszyk.click();
    }

    @FindBy(xpath = ("//a[@class='btn btn-primary']"))
    private WebElement kontynuujZakupy;

    public void ClickContinueShoping() {
        kontynuujZakupy.click();
    }


    @FindBy(xpath = ("//input[@name='id_address_delivery']"))
    private WebElement poprawnyAdderss;

    public void ClickCorrectAddress() {
        if (!poprawnyAdderss.isSelected()) {
            poprawnyAdderss.click();
        }

    }

    @FindBy(xpath = ("//section[@id=\"checkout-delivery-step\"]"))
    private WebElement shippingMethod;

    public void ClickShippingMethod() {
        shippingMethod.click();

    }

    @FindBy(xpath = ("//input[@id='delivery_option_1']"))
    private WebElement prestaShop;

    public void ClickPrestaShop() {
        if (!prestaShop.isSelected()) {
            prestaShop.click();
        }
    }

    @FindBy(xpath = ("//section[@id=\"checkout-payment-step\"]"))
    private WebElement paymentMethod;

    public void ClickPaymentMethod() {
        paymentMethod.click();

    }

    @FindBy(xpath = ("//input[@id='payment-option-1']"))
    private WebElement payByCheck;

    public void ClickPpayByCheck() {
        if (!payByCheck.isSelected()) {
            payByCheck.click();
        }
    }

    @FindBy(xpath = ("//input[@id=\"conditions_to_approve[terms-and-conditions]\"]"))
    private WebElement conditions;

    public void ClickConditions() {
        if (!conditions.isSelected()) {
            conditions.click();
        }
    }

    @FindBy(xpath = ("//button[@class=\"btn btn-primary center-block\"]"))
    private WebElement lastClick;

    public void ClickLastButton() {
        lastClick.click();
    }


}
