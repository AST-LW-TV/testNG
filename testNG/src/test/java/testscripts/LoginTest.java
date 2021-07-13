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
public class LoginTest {
    // Global variables
    private WebDriver driver;
    private BrowserSetUp browserSetUp;
    private HomePage homePage;
    private LoginPage loginPage;
    boolean error;

    // Data provider for valid login
    @DataProvider(name = "validLoginCredentials")
    public Object[][] validDetails() {
        return new Object[][]{
                {"ast-lw1@gmail.com", "tS2r7@JeSZfLxKB"},
                {"ast-lw2@gmail.com", "tS2r7@JeSZfLxKB"}
        };
    }

    // Data provider for invalid login
    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] invalidDetails() {
        return new Object[][]{
                {"abc@gmail.com", "12345"},
                {"xyz@gmail.com", "12345"}
        };
    }

    // sets the browser ...
    @BeforeMethod
    public void setUp(ITestContext context) {
        System.out.println("++++++++++Starting the Test...++++++++++");
        browserSetUp = new BrowserSetUp("http://practice.automationtesting.in/");
        driver = browserSetUp.getDriver();
        context.setAttribute("WebDriver", driver); // sets the context variable for driver to be used in listener
        homePage = new HomePage(driver); // HomePage Initialization
        loginPage = new LoginPage(driver); // Login Initialization
    }

    // procedural steps ...
    private boolean steps(String username, String password, String flag) {
        homePage.getMyAccountLinkElement().click();
        loginPage.getUsernameElement().sendKeys(username);
        loginPage.getPasswordElement().sendKeys(password);
        loginPage.getLoginButtonElement().click();
        return flag.equalsIgnoreCase("valid") ? false : loginPage.invalidCredentialError();
    }

    // test for valid login credentials
    @Test(dataProvider = "validLoginCredentials", priority = 0)
    public void validLoginTest(String username, String password) {
        error = steps(username, password, "valid");
        Assert.assertEquals(false, error);
    }

    // test for invalid login credentials
    @Test(dataProvider = "invalidLoginCredentials", priority = 1)
    public void invalidLoginTest(String username, String password) {
        error = steps(username, password, "invalid");
        Assert.assertEquals(false, error); // test fails with invalid credentials
    }

    // quits the browser ...
    @AfterMethod
    public void tearDown() {
        browserSetUp.quitDriver();
        System.out.println("++++++++++Ending the Test...++++++++++");
    }
}