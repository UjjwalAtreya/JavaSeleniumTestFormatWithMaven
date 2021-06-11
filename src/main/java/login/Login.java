package login;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ITH on 11/30/2017.
 */
public class Login {

    WebDriver driver;

    @FindBy(id="username")
    WebElement loginTextField;


    @FindBy(xpath = "//div[@id='emptyError']/label/span")
    WebElement blankUserPassError;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserPassEmptyMsg() {
        String emptyErrorMsg = blankUserPassError.getText();
        System.out.println("the Error message is : " + emptyErrorMsg);
        return emptyErrorMsg;
    }

//    public void languageSelection(String language) throws InterruptedException {
//        for (WebElement we : selectLanguage) {
//            String languageSelection = we.getAttribute("onclick");
//            System.out.println("languages are : "+languageSelection);
//            System.out.println("input language is : "+language);
//            if (languageSelection.contains(language)) {
//                ((JavascriptExecutor) Logindriver).executeScript("arguments[0].click();", we);
//                break;
//            }
//        }
//    }
}
