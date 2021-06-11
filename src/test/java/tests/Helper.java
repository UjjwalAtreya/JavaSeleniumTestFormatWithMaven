package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.util.Strings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Helper {

    public static Properties prop;
    public static String dataFolderBasePath = "data/config/";

    static {
        prop = new Properties();
    }




    //Take screenshot for failed test
    public static String takeScreenShot(String imageFileName) throws IOException, InterruptedException {
        TakesScreenshot screenshot = (TakesScreenshot) Helper.getDriver();
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg"));
        String filePath = System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg";
        return filePath;
    }


    //Wait for Page to Load

    public static void waitForPageToBeReady() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // Initially below given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        // This loop will rotate for 25 times to check If page Is ready after every 1 second.
        int waitTime = 30; // 30 secs
        for (int i = 0; i < waitTime; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    // LocalWebDriverManager
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}

