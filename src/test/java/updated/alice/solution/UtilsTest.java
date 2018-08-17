package updated.alice.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UtilsTest {

    @Test
    public void calcMD5Hash() throws NoSuchAlgorithmException {

        String abcdString = "abcd";
        String abcdStringMD5Hash = Utils.calcMD5Hash(abcdString);

        Assertions.assertEquals("e2fc714c4727ee9395f324cd2e7f331f", abcdStringMD5Hash);
    }

    @Test
    public void combinationsWithDuplicates() {

        List<String[]> answers = Utils.allWordCombinationsInArray(new String[] {"1", "2"});

        List<List<String>> StringList = new LinkedList<List<String>>();

        for (String[] element : answers) {
            StringList.add(Arrays.asList(element));
        }

        // check all combinations
        Assertions.assertTrue(StringList.contains(Arrays.asList(new String[] {"1", "1"})));
        Assertions.assertTrue(StringList.contains(Arrays.asList(new String[] {"1", "2"})));
        Assertions.assertTrue(StringList.contains(Arrays.asList(new String[] {"2", "1"})));
        Assertions.assertTrue(StringList.contains(Arrays.asList(new String[] {"2", "2"})));
    }

    @Test
    public void numberOfWordsInSolutionAnagramTest() {

        String words2Anagram = "ab cd";
        int numberOfWords = Utils.numberOfWordsInSolutionAnagram(words2Anagram);

        Assertions.assertEquals(2, numberOfWords);
    }
}
