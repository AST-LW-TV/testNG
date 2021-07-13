package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.BrowserSetUp;
import utilities.Listener;
import utilities.pages.HomePage;
import utilities.pages.LoginPage;

@Listeners(Listener.class)
public class Login {
    private WebDriver driver;
    private BrowserSetUp browserSetUp;
    private HomePage homePage;
    private LoginPage loginPage;
    boolean error;

    @DataProvider(name = "validLoginCredentials")
    public Object[][] validDetails() {
        return new Object[][]{
                {"ast-lw1@gmail.com", "tS2r7@JeSZfLxKB"},
                {"ast-lw2@gmail.com", "tS2r7@JeSZfLxKB"}
        };
    }

    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] invalidDetails() {
        return new Object[][]{
                {"abc@gmail.com", "12345"},
                {"xyz@gmail.com", "12345"}
        };
    }

    @BeforeMethod
    public void setUp(ITestContext context) {
        browserSetUp = new BrowserSetUp("http://practice.automationtesting.in/");
        driver = browserSetUp.getDriver();
        context.setAttribute("WebDriver", driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    private boolean steps(String username, String password, String flag) {
        homePage.getMyAccountLinkElement().click();
        loginPage.getUsernameElement().sendKeys(username);
        loginPage.getPasswordElement().sendKeys(password);
        loginPage.getLoginButtonElement().click();
        return flag.equalsIgnoreCase("valid") ? false : loginPage.invalidCredentialError();
    }

    @Test(dataProvider = "validLoginCredentials")
    public void validLoginTest(String username, String password) {
        error = steps(username, password, "valid");
        Assert.assertEquals(false, error);
    }

    @Test(dataProvider = "invalidLoginCredentials")
    public void invalidLoginTest(String username, String password) {
        error = steps(username, password, "invalid");
        Assert.assertEquals(false, error); // test fails with invalid credentials
    }

    @AfterMethod
    public void tearDown() {
        browserSetUp.quitDriver();
    }
}
