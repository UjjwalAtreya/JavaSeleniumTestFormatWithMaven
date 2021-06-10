package tests.loginTest;

import login.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import static tests.Helper.*;

/**
 * Created by ITH on 11/30/2017.
 */
public class LoginTest extends BaseTest {

    //  Login Test For Valid Username and Password
    @Test(description = "Test for Valid username and Password")
    public void test_For_Valid_Username_And_Password(String username, String password, String domain, String BaseUrl, String language, String mainUrl) throws InterruptedException {
        Login login = new Login(getDriver());
        LoginTest loginTest = new LoginTest();
        loginTest.invokeUrl(BaseUrl);

        //Entering Valid Login Credentials
        try {
            login.enterUserName(username);


            login.enterDomain(domain);
            //working till here

            login.clickLanguageSelector();
            Thread.sleep(5000);
            login.languageSelection(language);

            Thread.sleep(5000);

            login.clickLoginButon();
            Thread.sleep(2000);

            String popup = handelPopUp();

            //Login success Assertion
            Thread.sleep(10000);
            try {
                String mainPageUrl = getDriver().getCurrentUrl();
                Assert.assertEquals(mainPageUrl, mainUrl);
            } catch (Exception errorLogin) {
                if (popup != null) {
                } else {
                }
            }
        } catch (Exception e) {
        }
    }

    

    //  Test If Username/Password is Empty
       public void invokeUrl(String baseUrl) {
        try {
            invokeBrowser(baseUrl);
            Thread.sleep(5000);


        } catch (Exception errorInvoke) {
        }
    }

    private void invokeBrowser(String url) {
        getDriver().get(url);
    }
}
