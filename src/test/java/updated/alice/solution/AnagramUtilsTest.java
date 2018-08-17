package updated.alice.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AnagramUtilsTest {

    @Test
    public void isAnagram() {

        String abc = "abc";
        String cba = "cba";

        Map<String, Integer> abcLettersMap = Utils.createLettersMapFromWord(abc);
        Map<String, Integer> cbaLettersMap = Utils.createLettersMapFromWord(cba);
        Assertions.assertTrue(AnagramUtils.areTheseWordsAnagrams(abcLettersMap, cbaLettersMap));
    }

    @Test
    public void isNotAnagram() {

        String abcd = "abcd";
        String cba = "cba";

        Map<String, Integer> abcdLettersMap = Utils.createLettersMapFromWord(abcd);
        Map<String, Integer> cbaLettersMap = Utils.createLettersMapFromWord(cba);
        Assertions.assertFalse(AnagramUtils.areTheseWordsAnagrams(abcdLettersMap, cbaLettersMap));
    }

    @Test
    public void isNotAnagram2() {

        String aabcababc = "aabcababc";
        String babcaabca = "babcaabca";

        Map<String, Integer> aabcababcLettersMap = Utils.createLettersMapFromWord(aabcababc);
        Map<String, Integer> babcaabcaLettersMap = Utils.createLettersMapFromWord(babcaabca);
        Assertions.assertTrue(AnagramUtils.areTheseWordsAnagrams(aabcababcLettersMap, babcaabcaLettersMap));
    }
}
