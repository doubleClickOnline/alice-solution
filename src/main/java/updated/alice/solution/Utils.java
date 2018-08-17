package updated.alice.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 *
 * Utils class
 */
public class Utils {

    /**
     *
     * Read file content
     *
     * @param fileName Path to file
     * @return File content, each line in file as element(String) in list
     */
    public static List<String> readFile(String fileName) {

        List<String> list = new LinkedList<String>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * Create letters map from word
     *
     * @param word String word
     * @return Letters map, key as letter and value number of repetition
     */
    public static Map<String, Integer> createLettersMapFromWord(String word) {
        Map<String, Integer> wordMap = new ConcurrentHashMap<String, Integer>();

        for (char letter : word.toCharArray()) {
            String let = new String("" + letter);

            if (wordMap.containsKey(let)) {
                // increase counter
                wordMap.put(let, wordMap.get(let) + 1);
            } else {
                wordMap.put(let, 1);
            }
        }
        return wordMap;
    }

    /**
     *
     * Calculate string MD5 hash
     *
     * @param word String value
     * @return MD5 hash value of word
     * @throws NoSuchAlgorithmException Exception will be thrown
     * if MD5 cryptographic algorithm is not available in the environment.
     */
    public static String calcMD5Hash(String word) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(word.getBytes());
        BigInteger bigInt = new BigInteger(1,m.digest());
        return bigInt.toString(16);
    }

    /**
     *
     * Filter words from list
     *
     * @param solutionAnagram Anagram
     * @param allWords List of words
     * @param minLengthWord Min length of word to be included in filtered words list
     * @return Filteres words list
     */
    public static List<String> filteredWordsList(String solutionAnagram, List<String> allWords, int minLengthWord) {

        Map<String, Integer> solutionAnagramLettersMap = Utils.createLettersMapFromWord(solutionAnagram);
        return allWords
                .stream()
                .filter(word ->
                        ((word.length() >= minLengthWord) &&
                                AnagramUtils.wordCouldBePartOfAnagram(word, solutionAnagramLettersMap)))
                .collect(Collectors.toList());
    }

    /**
     *
     * Create list of words, with all possible combinations from words in array arr
     *
     * @param arr Array of Strings
     * @return All possible combinations of words in array
     */
    public static List<String[]> allWordCombinationsInArray(String[] arr) {

        List<String[]> list = new LinkedList<String[]>();

        if (null != arr && arr.length != 0) {
            int numArrays = (int)Math.pow(arr.length, arr.length);
            for(int i = 0; i < numArrays; i++) {
                list.add(new String[arr.length]);
            }
            // Fill up the arrays
            for(int j = 0; j < arr.length; j++) {
                int period = (int) Math.pow(arr.length, arr.length - j - 1);
                for(int i = 0; i < numArrays; i++) {
                    String[] current = list.get(i);
                    // Get the correct item and set it
                    int index = i / period % arr.length;
                    current[j] = arr[index];
                }
            }
        }
        return list;
    }

    /**
     *
     * Number of words in anagram
     *
     * @param anagram String anagram
     * @return Number of words in anagram
     */
    public static int numberOfWordsInSolutionAnagram(String anagram) {

        int counter = 0;
        Map<String, Integer> lettersMap = createLettersMapFromWord(anagram);
        if (lettersMap.containsKey(" ")) {
            counter = lettersMap.get(" ");
        }
        return counter + 1;
    }
}
