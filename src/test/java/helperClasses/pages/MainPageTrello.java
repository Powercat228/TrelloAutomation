package helperClasses.pages;

import loginSuite.core.Elem;
import org.openqa.selenium.By;

public class MainPageTrello extends LoginPageTrello{

        private String pageUrl = "https://trello.com/";
        public LoginPageTrello loginPageTrello = new LoginPageTrello();
        private Elem loginBtn = new Elem(By.cssSelector(".global-header-section-button"),"Email Field");

        public void open(){
            driver().get(pageUrl);
        }

        public void openLoginPage(){
            loginBtn.click();
        }

    }