package pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
    private static WebDriver driver;

    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}