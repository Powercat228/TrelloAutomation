package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;

public class PopUpCreateCommand extends MethodsFactory {

    private Elem nameCommand = new Elem(By.xpath("//input[@id='org-display-name']"));
    private Elem createBtn = new Elem(By.xpath("//input[@class='primary wide js-save']"));

    public void createCommand(String info){
        nameCommand.type(info);
        createBtn.click();
    }
}
