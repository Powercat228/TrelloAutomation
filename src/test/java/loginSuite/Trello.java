package loginSuite;

import loginSuite.core.BrowserFactory;
import helperClasses.ApiManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helperClasses.pages.*;

public class Trello extends BrowserFactory {
    MainPageTrello mainPage = new MainPageTrello();
    BoardPage boardPage = new BoardPage();
    helperClasses.pages.PopUpCreateCommand popUpCreateCommand = new PopUpCreateCommand();
    helperClasses.pages.NewCommand newCard = new NewCommand();
    BoardWithoutName boardWithoutName = new BoardWithoutName();
    PopUpSettingsNewCard popUpSettingsNewCard = new PopUpSettingsNewCard();
    ApiManager apiManager = new ApiManager();



    @BeforeMethod
    public void login(){
        mainPage.open();
        mainPage.openLoginPage();
        mainPage.loginPageTrello.login("tarasenkoalenka@gmail.com", "210686aa");

//        Assert.assertTrue(boardPage.boardSection.isPresent(), "Board page is not opened!");
    }

    @Test // создание команды
    public void createCommand(){
        boardPage.createNewCommand();
        popUpCreateCommand.createCommand("hhhh123");
        Assert.assertEquals("hhhh123", newCard.nameNewCommand());
    }

    @Test // создание карточки
    public void createCard(){
        boardPage.openBoardWithOutName();
        boardWithoutName.addCard("newCard");
        Assert.assertEquals("newCard", boardWithoutName.nameNewCard());
    }


    @Test // просмотр архивированных элементов
    public void moveToArchive(){
        String id = apiManager.createBoard();
        String str = apiManager.createList(id);
        apiManager.createCard(str);
        popUpSettingsNewCard.moveInArchive();


    }


    @Test // перемещение карточки по спискам (нужна помощь с селектами)
    public void moveCardToLists(){
        boardPage.openBoardWithOutName();
        boardWithoutName.addCard("newCard");
        boardWithoutName.openSettingsNewCard();
        popUpSettingsNewCard.moveCard();
        popUpSettingsNewCard.chooseSelect();

    }

    @Test
    public void deleteList(){
        apiManager.createBoard();

    }
}

