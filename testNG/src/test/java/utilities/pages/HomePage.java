package utilities.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.PageReference;

public class HomePage extends PageReference {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    public WebElement getMyAccountLinkElement() {
        return myAccountLink;
    }
}
