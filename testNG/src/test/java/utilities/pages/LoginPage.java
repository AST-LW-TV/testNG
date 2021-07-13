package utilities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PageReference;

// Login page
public class LoginPage extends PageReference {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "input[name='login']")
    WebElement loginButton;

    public WebElement getUsernameElement() {
        return username;
    }

    public WebElement getPasswordElement() {
        return password;
    }

    public WebElement getLoginButtonElement() {
        return loginButton;
    }

    public boolean invalidCredentialError() {
        By errorLogin = By.cssSelector(".woocommerce-error");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLogin));
        return driver.findElement(errorLogin).isDisplayed();
    }
}
