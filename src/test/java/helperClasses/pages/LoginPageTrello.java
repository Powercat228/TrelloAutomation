package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;

public class LoginPageTrello extends MethodsFactory {

        private Elem emailFld = new Elem(By.cssSelector("input#user"), "Email Field");
        private Elem passwordFld = new Elem(By.cssSelector("input#password"), "User Password");
        private Elem loginBtn = new Elem(By.cssSelector("input#login"),"Submit Button");

        public void login(String email, String password){
            emailFld.type(email);
            passwordFld.type(password);
            loginBtn.click();
        }
    }
