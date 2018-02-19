package helperClasses.pages;

import loginSuite.core.Elem;
import loginSuite.core.MethodsFactory;
import org.openqa.selenium.By;

public class BoardPage extends MethodsFactory {
        public Elem boardSection = new Elem(By.cssSelector(".boards-page-board-section:nth-child(1)"));
        public Elem createNewCommandBtn = new Elem(By.cssSelector(".quiet-button.u-float-left"), "Create New Command Button");
        public Elem boardWitoutName = new Elem(By.cssSelector(".board-tile-details-name"));

        public void createNewCommand() {
            createNewCommandBtn.click();
        }

        public void openBoardWithOutName(){
            boardWitoutName.click();
        }

}
