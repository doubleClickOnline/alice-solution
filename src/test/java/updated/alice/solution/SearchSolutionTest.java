package updated.alice.solution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SearchSolutionTest {

    @Test
    void searchSolutionSameWordTest() throws NoSuchAlgorithmException {

        String solution = "aabacabc";
        String solutionAnagram = "aabacabc";
        List<String> allWords = new LinkedList<String>();
        allWords.add("abc");
        allWords.add("aabc");
        allWords.add("aabca");
        allWords.add("babc");
        allWords.add("vabc");
        allWords.add("zxczcabc");
        allWords.add("sadsadabc");
        allWords.add("zxczxcabc");
        allWords.add("erwerwabc");
        allWords.add("aaposabc");
        allWords.add("aabacabc");

        Set<String> answers = new SearchSolution().search(solutionAnagram, allWords, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", "");
        Assertions.assertEquals("aabacabc", returnAnswer);
    }

    @Test
    void searchSolutionSameWordTest2() throws NoSuchAlgorithmException {

        String solutionAnagram = "zxczcabc";
        List<String> allWords = new LinkedList<String>();
        allWords.add("abc");
        allWords.add("aabc");
        allWords.add("aabca");
        allWords.add("babc");
        allWords.add("vabc");
        allWords.add("zxczcabc");
        allWords.add("sadsadabc");
        allWords.add("zxczxcabc");
        allWords.add("erwerwabc");
        allWords.add("aaposabc");
        allWords.add("aabacabc");

        Set<String> answers = new SearchSolution().search(solutionAnagram, allWords, Utils.calcMD5Hash(solutionAnagram), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals("zxczcabc", returnAnswer);
    }

    @Test
    void searchSolution2WordsTest() throws NoSuchAlgorithmException {

        String solution = "babc zxczcabc";
        String solutionAnagram = "zxczcabc babc";

        List<String> allWords = new LinkedList<String>();
        allWords.add("abc");
        allWords.add("aabc");
        allWords.add("aabca");
        allWords.add("babc");
        allWords.add("vabc");
        allWords.add("zxczcabc");
        allWords.add("sadsadabc");
        allWords.add("zxczxcabc");
        allWords.add("erwerwabc");
        allWords.add("aaposabc");
        allWords.add("cbacabaa");

        Set<String> answers = new SearchSolution().search(solutionAnagram, allWords, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals("babc zxczcabc", returnAnswer);
    }

    @Test
    void searchSolution2WordsTest2() throws NoSuchAlgorithmException {

        String solution = "aabc aabca";
        String solutionAnagram = "aabca abca";

        List<String> allWords = new LinkedList<String>();
        allWords.add("abc");
        allWords.add("aabc");
        allWords.add("aabca");
        allWords.add("babc");
        allWords.add("vabc");
        allWords.add("zxczcabc");
        allWords.add("sadsadabc");
        allWords.add("zxczxcabc");
        allWords.add("erwerwabc");
        allWords.add("aaposabc");
        allWords.add("cbac");
        allWords.add("abaa");

        Set<String> answers = new SearchSolution().search(solutionAnagram, allWords, Utils.calcMD5Hash(solution),1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals("aabc aabca", returnAnswer);
    }

    @Test
    public void abaciTestSearch1() throws NoSuchAlgorithmException {

        String solution = "abaci";
        String solutionAnagram = "abaci";
        List<String> words = DummyData.createSampleWordsList();

        Set<String> answers = new SearchSolution().search(solutionAnagram, words, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals("abaci", returnAnswer);
    }

    @Test
    public void abaciabacusTestSearch2() throws NoSuchAlgorithmException {

        String solution = "abaci abacus";
        String solutionAnagram = "abaci abacus";
        List<String> words = DummyData.createSampleWordsList();

        Set<String> answers = new SearchSolution().search(solutionAnagram, words, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals("abaci abacus", returnAnswer);
    }

    @Test
    public void wasiaabaciabacusTestSearch3() throws NoSuchAlgorithmException {

        String solution= "abaci abacus asia";
        String solutionAnagram = "asia abaci abacus";
        List<String> words = DummyData.createSampleWordsList();

        Set<String> answers = new SearchSolution().search(solutionAnagram, words, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals(solution, returnAnswer);
    }

    @Test
    public void bustbulishTestSearch() throws NoSuchAlgorithmException {

        String solution= "bulish bust";
        String solutionAnagram = "bust bulish";
        List<String> words = DummyData.createSampleWordsList();

        Set<String> answers = new SearchSolution().search(solutionAnagram, words, Utils.calcMD5Hash(solution), 1);
        Assertions.assertEquals(1, answers.size());

        String returnAnswer = String.join(",", answers).replaceAll(",", " ");
        Assertions.assertEquals(solution, returnAnswer);
    }
}
