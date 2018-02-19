package helperClasses.pages;

import loginSuite.core.Elem;
import org.openqa.selenium.By;

public class BoardWithoutName {
    public Elem addCardBtn = new Elem(By.cssSelector(".open-card-composer.js-open-card-composer"));
    public Elem textAreaNewCard = new Elem(By.cssSelector(".list-card-composer-textarea.js-card-title"));
    public Elem createCardBtn = new Elem(By.cssSelector(".primary.confirm.mod-compact.js-add-card"));
    public Elem newCard = new Elem(By.cssSelector(".list-card-title.js-card-name"));


    public void addCard(String info){
        addCardBtn.click();
        textAreaNewCard.type(info);
        createCardBtn.click();
    }

    public String nameNewCard (){
        return newCard.getText();
    }

    public void openSettingsNewCard(){
        newCard.click();
    }
}
