package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;

public class LoginForm extends MethodsFactory {

    private Elem emailFld = new Elem(By.cssSelector("#user-email"), "Email Field");
    private Elem passwordFld = new Elem(By.cssSelector("#user-password"), "Password Field");
    private Elem submitBtn = new Elem(By.cssSelector("#sign-in-form .submit"), "Submit Button");

    public void login(String email, String password){
        emailFld.type(email);
        passwordFld.type(password);
        submitBtn.click();
    }
}
