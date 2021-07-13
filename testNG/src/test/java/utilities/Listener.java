package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// testNG listener
public class Listener implements ITestListener {
    WebDriver driver = null;

    // takes the screenshot when the test is success and stores in screenshot directory - success_{}
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver"); // getting the context variable
        driver.findElement(By.linkText("Shop")).click();
        ScreenShot.TakeScreenShot(driver, "success"); // screenshot functionality
    }

    // takes the screenshot when the test is fails and stores in screenshot directory - errorLogin_{}
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver"); // getting the context variable
        ScreenShot.TakeScreenShot(driver, "errorLogin"); // screenshot functionality
    }
}
