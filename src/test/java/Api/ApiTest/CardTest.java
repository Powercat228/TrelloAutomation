package Api.ApiTest;
import Api.ApiPattern;
import Api.Objects.Card;
import io.qameta.allure.Feature;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

@Feature("Cards")

public class CardTest {
    final String listId = "5a9a9504699eca1e8d6c30a6";
    ApiPattern apiPattern = new ApiPattern();
    RandomStringGenerator randomStringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', 'z')
                    .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                    .build();

    @Test (description = "Создание карточки")
    public void testCreateCard() throws IOException {
        Card card1 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);

        Assert.assertEquals(card1.getName(), "");
        Assert.assertFalse(card1.getId().isEmpty());
        System.out.println(card1);
    }

    @Test (description = "Переименование карточки")
    public void testUpdateCardName() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        String name = "New cards for my best teacher";
        card2 = apiPattern.putUpdateCardName(card1.getId(), name, card2);

        Assert.assertEquals(card2.getName(), name);
    }

    @Test (description = "Обновление дескрипшина в карточке")
    public void testUpdateCardDesc() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        String desc = "It's a new card... That's all";
        card2 = apiPattern.putUpdateCardDesc(card1.getId(), desc, card2);

        Assert.assertEquals(card2.getDesc(), desc);
    }

    @Test (description = "получение карточки по её id")
    public void testGetCard() throws IOException {
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        card2 = apiPattern.getCard(card1.getId(), card2);

        Assert.assertEquals(card2.id, card1.id);
    }

    //ДИМОН!!!!
    // какую сделать проверку на наличие коммента?

    @Test (description = "Написание комментария в карточке")
    public void testAddCardComment() throws IOException {
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        System.out.println(card1);
        String text = "free newcomment";
        card2 = apiPattern.postAddNewCardComment(card1.getId(), text, card2);

    }


    //ДИМОН!!!!
    // какую сделать проверку на то что карточки нет?
    @Test (description = "Удаление карточки")
    public void testDeleteCard() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        card2 = apiPattern.deleteCard(card1.getId(), card2);
        Assert.assertFalse(card1.getId().isEmpty());

    }









//    @Test // 4.	Добавление лейбла в карточку
//    public void testUpdateCardIdLabels() throws IOException{
//        Card card1 = new Card();
//        Card card2 = new Card();
//
//        card1 = apiPattern.postCreateCard(listId, card1);
//        String idLabels = "mega new idLabels";
//        card2 = apiPattern.putUpdateCardIdLabels(card1.getId(), idLabels, card2);
//
//        Assert.assertEquals(card2.getidLabels(), idLabels);
//        System.out.println(card2);
//    }


    @Test // непереоперделяет listId
    public void testNegativeCreateCard() throws IOException {
        Card card1 = new Card();

        String listId = "1";
        String name = "false_card";
        card1 = apiPattern.postCreateCardNeg(listId, name, card1);

//        Assert.assertEquals(card1, "invalid value for idList");
//        Assert.assertEquals(card1.getName(), "");
//        Assert.assertFalse(card1.getId().isEmpty());
//        System.out.println(card1);
    }
}
