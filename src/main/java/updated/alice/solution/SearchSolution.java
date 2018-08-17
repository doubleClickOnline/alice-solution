package updated.alice.solution;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Implementation to search solution
 */
public class SearchSolution {

    /**
     *
     * Find solution
     *
     * @param solutionAnagram Solution anagram
     * @param allWords List of all possible words in solution
     * @param solutionMD5Hash Solution MD5 hash
     * @param minLengthWord Min length of words in solution (filter part of words)
     * @return answer
     * @throws NoSuchAlgorithmException if MD5 cryptographic algorithm is not available in the environment
     */
    public List<String> search(String solutionAnagram, List<String> allWords, String solutionMD5Hash, int minLengthWord) throws NoSuchAlgorithmException {

        System.out.println("Start " + new Date().toString());
        System.out.println("Solution anagram: " + solutionAnagram);
        System.out.println("Solution md5 hash: " + solutionMD5Hash);

        // All words from file
        System.out.println("Solution words list size " + allWords.size());

        // Filtered words
        String solutionAnagramWithoutSpaces = solutionAnagram.replaceAll(" ", "");
        List<String> filteredWords = Utils.filteredWordsList(solutionAnagramWithoutSpaces, allWords, minLengthWord);
        System.out.println("Filtered words list size " + filteredWords.size());

        // Number of words in solution anagram
        int numberOfWords = Utils.numberOfWordsInSolutionAnagram(solutionAnagram);
        System.out.println("Number Of words in anagram " + numberOfWords);

        // Search solution
        List<String> allSolutions = searchListOfWordsAsAnagram(solutionAnagramWithoutSpaces, filteredWords, solutionMD5Hash, numberOfWords);

        // Stop time
        System.out.println("Stop time: " + new Date().toString());
        return allSolutions;
    }

    /**
     *
     * Search list of words as anagram
     *
     * @param solutionAnagram solution anagram
     * @param filteredWords list of words
     * @param solutionMD5Hash solution MD5 hash
     * @param howManyWords number of words in solution
     * @return list of words as anagram
     * @throws NoSuchAlgorithmException if MD5 cryptographic algorithm is not available in the environment
     */
    private List<String> searchListOfWordsAsAnagram(String solutionAnagram, List<String> filteredWords, String solutionMD5Hash, int howManyWords) throws NoSuchAlgorithmException {

        Map<String, Integer> anagramSolutionLettersMap = Utils.createLettersMapFromWord(solutionAnagram);
        int anagramSolutionLength = solutionAnagram.length();
        int anagramSolutionHash = solutionAnagram.hashCode();

        List<String> allSolutions = new LinkedList<String>();
        WordsListAsAnagram wordAnagrams = new WordsListAsAnagram()
                .addWordsList(filteredWords)
                .addNumberOfCombinations(howManyWords)
                .addAnagramSolutionLettersMap(anagramSolutionLettersMap)
                .addAnagramSolutionLength(anagramSolutionLength)
                .create();

        // Create words list, anagram
        List<List<String>> allAtempts = wordAnagrams.createWordsListAsAnagram();
        for (List<String> wordsList : allAtempts) {

            // Create list of all possible words combination in list
            List<String[]> wordCombinations = Utils.allWordCombinationsInArray(wordsList.toArray(new String[wordsList.size()]));
            
            for (String[] combinationOne : wordCombinations) {
                // Try if words combination is a solution
                String solutionAttempt =  Arrays.asList(combinationOne).stream().collect(Collectors.joining(" "));

                // if MD5 hash equals it is solution
                if (Utils.calcMD5Hash(solutionAttempt).equals(solutionMD5Hash)) {
                    allSolutions.add(solutionAttempt);
                    return allSolutions;
                }
            }
        }
        return allSolutions;
    }

}
