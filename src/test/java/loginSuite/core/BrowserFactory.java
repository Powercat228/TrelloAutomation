package loginSuite.core;

import org.openqa.selenium.chrome.ChromeDriver;
import static loginSuite.core.MethodsFactory.DRIVER;
import static loginSuite.core.MethodsFactory.driver;

import org.testng.annotations.*;

public class BrowserFactory {

    @BeforeTest
    public void setUp(){
        DRIVER.set(new ChromeDriver());
    }


    @AfterTest
    public void tearDown(){
        driver().quit();
    }

}

