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

    @Test (description = "Create card")
    public void testCreateCard() throws IOException {
        Card card1 = new Card();

        String name = randomStringGenerator.generate(7);
        card1 = apiPattern.postCreateCard(listId, name, card1);

        Assert.assertEquals(card1.getName(), name);
        Assert.assertFalse(card1.getId().isEmpty());
        System.out.println(card1);
    }

    @Test (description = "Rename card")
    public void testUpdateCardName() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        String name1 = randomStringGenerator.generate(7);
        card1 = apiPattern.postCreateCard(listId, name1, card1);
        String name2 = "New cards for my best teacher";
        card2 = apiPattern.putUpdateCardName(card1.getId(), name2, card2);

        Assert.assertEquals(card2.getName(), name2);
    }

    @Test (description = "Update description")
    public void testUpdateCardDesc() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        String name = randomStringGenerator.generate(7);
        card1 = apiPattern.postCreateCard(listId, name, card1);
        String desc = "It's a new card... That's all";
        card2 = apiPattern.putUpdateCardDesc(card1.getId(), desc, card2);

        Assert.assertEquals(card2.getDesc(), desc);
    }


    @Test (description = "Get a card by its ID")
    public void testGetCard() throws IOException {
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        card2 = apiPattern.getCard(card1.getId(), card2);

        Assert.assertEquals(card2.id, card1.id);
    }

    @Test (description = "Create a new checklist on a card")
    public void testCreateCheckListCard() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        String name1 = randomStringGenerator.generate(7);
        card1 = apiPattern.postCreateCard(listId, name1, card1);
        String nameCheckList = "New New CheckList";
        card2 = apiPattern.postAdCheckListCard(card1.getId(), nameCheckList, card2);

        System.out.println(card1);
        System.out.println(card2);
    }






/*    @Test (description = "Add comment in a card")
    public void testAddCardComment() throws IOException {
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        System.out.println(card1);
        String text = "free newcomment";
        card2 = apiPattern.postAddNewCardComment(card1.getId(), text, card2);
        System.out.println(card1);
        System.out.println(card2); */

    /*@Test (description = "Удаление карточки")
    public void testDeleteCard() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        card2 = apiPattern.deleteCard(card1.getId(), card2);
        card3 = apiPattern.getCard(card1.getId(), card3);
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);
        Assert.assertTrue(card2.getId().isEmpty());
        Assert.assertTrue(card2.getIdBoard().isEmpty());
        Assert.assertTrue(card2.getIdList().isEmpty());
    }*/


    /*@Test // 4.	Добавление лейбла в карточку
    public void testUpdateCardIdLabels() throws IOException{
        Card card1 = new Card();
        Card card2 = new Card();

        card1 = apiPattern.postCreateCard(listId, card1);
        String idLabels = "mega new idLabels";
        card2 = apiPattern.putUpdateCardIdLabels(card1.getId(), idLabels, card2);

        //Assert.assertEquals(card2.getidLabels(), idLabels);
        System.out.println(card2);
    }*/


    /*@Test // непереоперделяет listId
    public void testNegativeCreateCard() throws IOException {
        Card card1 = new Card();

        String listId = "1";
        //String name = "false_card";
        String name = randomStringGenerator.generate(7);
        card1 = apiPattern.postCreateCard(listId, name, card1);

        Assert.assertEquals(card1, "invalid value for idList");
        Assert.assertEquals(card1.getName(), "");
        Assert.assertFalse(card1.getId().isEmpty());
        System.out.println(card1);
    }*/
}
