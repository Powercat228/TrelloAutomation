package loginSuite.core;

import org.openqa.selenium.WebDriver;

public class MethodsFactory {
    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();// статическая переменная в рамках одного потока

    public static WebDriver driver(){
        return DRIVER.get();
    }

}
