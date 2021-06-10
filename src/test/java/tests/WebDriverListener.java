package tests;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;

public class WebDriverListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = null;
            try {
                driver = BaseTest.createInstance();
            } catch (IOException | EmailException e) {
                e.printStackTrace();
            }
            Helper.setWebDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //do something after Invocation

    }
}
