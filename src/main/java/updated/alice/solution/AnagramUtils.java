package updated.alice.solution;

import java.util.Map;
import java.util.Set;

/**
 *
 * Utils class as help with anagrams
 */
public class AnagramUtils {

    /**
     *
     * Word could be part of solution anagram
     *
     * @param word String
     * @param solutionAnagramLettersMap anagram letters map
     * @return word could be part of anagram
     */
    public static boolean wordCouldBePartOfAnagram (String word, Map<String, Integer> solutionAnagramLettersMap) {

        Set<String> solutionAnagramKeys = solutionAnagramLettersMap.keySet();

        Map<String, Integer> wordLettersMap = Utils.createLettersMapFromWord(word);
        Set<String> wordMapKeys = wordLettersMap.keySet();

        if (solutionAnagramKeys.containsAll(wordMapKeys)) {
            for (String key : wordMapKeys) {
                if (solutionAnagramLettersMap.get(key) < wordLettersMap.get(key)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     *
     * Check if words are anagrams, compare words letters maps
     *
     * @param wordAnagramMap words letters map
     * @param anotherWordCandidateMap words letters map
     * @return if words letter maps are equal
     */
    public static boolean areTheseWordsAnagrams(Map<String, Integer> wordAnagramMap,
                                                Map<String, Integer> anotherWordCandidateMap) {

        boolean result = false;

        Set<String> solutionKeys = wordAnagramMap.keySet();
        Set<String> candidateSolutionKeys = anotherWordCandidateMap.keySet();
        if (candidateSolutionKeys.size() == solutionKeys.size() &&
                candidateSolutionKeys.containsAll(solutionKeys)) {

            for (String key : solutionKeys) {
                if (wordAnagramMap.get(key) == anotherWordCandidateMap.get(key)) {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;
    }
}
