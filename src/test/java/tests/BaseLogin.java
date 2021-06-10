package tests;

import login.Login;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;

import java.io.IOException;

import static tests.Helper.*;

public class BaseLogin extends BaseTest {

    public void validTest() throws InterruptedException, IOException {
        Login login = new Login(getDriver());

        try {
            //Invoking URL
            invokeBrowser(prop.getProperty("BaseUrl"));

        } catch (Exception errorUrlInvoke) {
        }

        //Entering Valid Login Credentials
        try {

            login.enterUserName(prop.getProperty("validUserName"));

            login.enterPassword(decrypt(prop.getProperty("validPassword")));

            login.enterDomain(prop.getProperty("domain"));

            login.clickLanguageSelector();
            login.languageSelection("English (United States)");


            login.clickLoginButon();

            try {
                handelPopUp();
            } catch (UnhandledAlertException popup) { }

            //Login success Assertion
            try {
                String mainPageUrl = getDriver().getCurrentUrl();
                Assert.assertEquals(mainPageUrl, prop.getProperty("mainPageUrl"));

            } catch (Exception errorLogin) {
                }

        } catch (Exception e) {
            }
    }

    private void invokeBrowser(String url) {
        getDriver().get(url);
    }
}
