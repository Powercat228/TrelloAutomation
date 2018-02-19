package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PopUpSettingsNewCard extends MethodsFactory {
    private Elem moveCardBtn = new Elem(By.cssSelector(".button-link.js-move-card"));
    private Elem moveInArchiveBtn = new Elem(By.cssSelector(".button-link js-archive-card"));
    private Elem archieveBannerText = new Elem(By.cssSelector(".window-archive-banner-text"));
    private Elem closePopUpCard = new Elem(By.cssSelector(""));



    private Elem selectBoardEl = new Elem(By.cssSelector(".js-select-board"));

    private Select select;
    public Select getSelect(Elem elem) {
        select = new Select((WebElement) elem);
        return select;
    }

    private Elem listText = new Elem(By.xpath("//*[@class='button-link setting form-grid-child form-grid-child-full']//select[1]"));



    private Elem moveSubmitBtn = new Elem(By.cssSelector(".primary wide js-submit"));


    public void moveCard(){
        moveCardBtn.click();
    }

    public void moveInArchive(){
        moveInArchiveBtn.click();
    }



    public void chooseSelect(){
        getSelect(listText);
        select.selectByVisibleText("Доска без названия");
    }

}
