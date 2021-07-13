package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/*
    screen shot functionality
 */
public class ScreenShot {
    public static void TakeScreenShot(WebDriver driver, String fileName) {
        try {
            String path = "./src/test/java/utilities/screenshot/";
            int count = new File(path).list().length;
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile, new File(path + fileName + "_" + String.valueOf(count + 1) + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshot error...");
            System.exit(-1);
        }
    }
}
