package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// page object model helper class
public class PageReference {
    public PageReference(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
