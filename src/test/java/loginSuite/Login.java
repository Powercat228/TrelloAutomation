package loginSuite;

import loginSuite.core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import helperClasses.pages.MainPage;

public class Login extends BrowserFactory {
    MainPage mainPage = new MainPage();

    @Test
    public void login(){
        mainPage.open();
        mainPage.loginForm.login("tarasenkoalenka@gmail.com","210686aa");

        Assert.assertTrue("".contains(""));
    }
}
