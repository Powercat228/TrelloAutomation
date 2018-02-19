package loginSuite.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static loginSuite.core.MethodsFactory.driver;

public class Elem {
    private int waitTime = 15;

    private By by;
    private String name= "";
    private Select select;

    public Elem(By by, String name){
        this.by = by;
        this.name = name;
    }

    public Elem(By by){
        this.by = by;
    }

    public WebElement find(){

        Select select = new Select(driver().findElement(By.xpath("")));
select.selectByIndex(1);

        return find(waitTime);
    }

    public WebElement find(int waitTime){
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        try {
            return wait.withMessage(name).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e){
            if(e.getCause().toString().contains("org.openqa.selenium.NoSuchElementException")){
                NoSuchElementException ne = new NoSuchElementException("Element: '"+toString()+"' not found on page: "+driver().getCurrentUrl());
                ne.setStackTrace(e.getStackTrace());
                throw ne;
            }
            throw e;
        }
    }

    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    public void click(){
        find().click();
    }

    public String getText(){
        return find().getText();
    }

    public boolean isPresent() {
        if (find().isDisplayed()) {
            return true;
        }
        return false;
    }

    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}