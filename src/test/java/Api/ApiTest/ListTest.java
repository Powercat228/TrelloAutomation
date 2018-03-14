package Api.ApiTest;

import Api.ApiPattern;
import Api.Objects.Listt;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class ListTest {
        final String idBoard = "5a9a94904674df7775f91294";
        ApiPattern apiPattern = new ApiPattern();
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .build();


        @Test // 1. Создание листа
        public void testCreateLists() throws IOException {
            Listt listt1 = new Listt();

            String name = randomStringGenerator.generate(7);
            listt1 = apiPattern.postCreateList(name, idBoard, listt1);

            Assert.assertEquals(listt1.getName(), name);
            Assert.assertEquals(listt1.getIdBoard(), idBoard);
            Assert.assertFalse(listt1.getId().isEmpty());
        }

        @Test // 2. Переименование листа
        public void testRenameList() throws IOException {
            Listt listt1 = new Listt();
            Listt listt2 = new Listt();

            String name1 = randomStringGenerator.generate(7);
            String name2 = randomStringGenerator.generate(11);
            listt1 = apiPattern.postCreateList(name1, idBoard, listt1);
            listt2 = apiPattern.putUpdateListName(listt1.getId(), name2, listt2);
            Assert.assertEquals(listt2.getName(), name2);
            Assert.assertEquals(listt1.getId(), listt2.getId());
        }
}
