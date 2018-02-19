package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;

public class NewCommand extends MethodsFactory {

    private Elem newCommand = new Elem(By.xpath("//h1[@class='u-inline']"));

    public String nameNewCommand(){
       return newCommand.getText();

    }
}
