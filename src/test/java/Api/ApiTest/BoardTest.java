package Api.ApiTest;

import Api.ApiPattern;
import Api.Objects.Board;
import io.qameta.allure.Feature;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Boards")

public class BoardTest {
    ApiPattern apiPattern = new ApiPattern();
    RandomStringGenerator randomStringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', 'z')
                    .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                    .build();


    @Test (description = "Создание борда")
    public void testCreateBoard() throws IOException {
       Board board1 = new Board();
       String name = randomStringGenerator.generate(7);

       board1 = apiPattern.postCreateBoard(name, board1);

       Assert.assertEquals(board1.getName(), name);
       Assert.assertFalse(board1.getId().isEmpty());
    }

    @Test (description = "Переименование борда")
    public void testUpdateBoardName() throws IOException {
        Board board1 = new Board();
        Board board2 = new Board();

        String name = randomStringGenerator.generate(7);
        String name2 = randomStringGenerator.generate(10);
        board1 = apiPattern.postCreateBoard(name, board1);
        board2 = apiPattern.putUpdateBoardName(board1.getId(), name2, board2);

        Assert.assertEquals(board2.getName(), name2);
        Assert.assertEquals(board1.getId(), board2.getId());
        Assert.assertEquals(board1.getShortUrl(), board2.getShortUrl());
    }

    @Test (description = "Добавление лейблов в борд")
    public void testAddBoardLabels() throws IOException {
        Board board1 = new Board();
//        Board board2 = new Board();

        String name = randomStringGenerator.generate(7);
        String nameLabels = "new green LABEL";
        String colorLabels = "green";

//        board1 = apiPattern.postCreateBoard(name, board1);
//        board2 = apiPattern.postAddLabelsBoard(board1.getId(), nameLabels, colorLabels, board2);

        board1 = apiPattern.postAddLabelsBoard("5a9a94904674df7775f91294", nameLabels, colorLabels, board1);
        System.out.println(board1);
    }







    //ДИМОН!!!!
    // какую сделать проверку на то что борда нет?
    @Test (description = "Удаление борда")
    public void testDeleteBoard() throws IOException {
        Board board1 = new Board();
        Board board2 = new Board();

        String name = randomStringGenerator.generate(7);
        board1 = apiPattern.postCreateBoard(name, board1);
        board2 = apiPattern.deleteBoard(board1.getId(), board2);

    }



}
