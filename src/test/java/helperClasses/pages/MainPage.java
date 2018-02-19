package helperClasses.pages;

import loginSuite.core.MethodsFactory;

public class MainPage extends MethodsFactory{
    private String pageUrl = "https://kismia.com/";
    public LoginForm loginForm = new LoginForm();


    public void open(){
        driver().get(pageUrl);
    }
}
