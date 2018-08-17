package updated.alice.solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsListAsAnagram {

    private List<String> filteredWords;
    private int numberOfCombinations;
    private Map<String, Integer> anagramSolutionLettersMap;
    private int anagramSolutionLength;

    public WordsListAsAnagram() {}

    public WordsListAsAnagram(List<String> filteredWords,
                              int numberOfCombinations,
                              Map<String, Integer> anagramSolutionLettersMap,
                              int anagramSolutionLength) {

        this.filteredWords = filteredWords;
        this.numberOfCombinations = numberOfCombinations;
        this.anagramSolutionLettersMap = anagramSolutionLettersMap;
        this.anagramSolutionLength = anagramSolutionLength;
    }

    public WordsListAsAnagram addWordsList (List<String> filteredWords) {
        this.filteredWords = filteredWords;
        return this;
    }

    public WordsListAsAnagram addNumberOfCombinations(int numberOfCombinations) {
        this.numberOfCombinations = numberOfCombinations;
        return this;
    }

    public WordsListAsAnagram addAnagramSolutionLettersMap(Map<String, Integer> anagramSolutionLettersMap) {
        this.anagramSolutionLettersMap = anagramSolutionLettersMap;
        return this;
    }

    public WordsListAsAnagram addAnagramSolutionLength(int anagramSolutionLength) {
        this.anagramSolutionLength = anagramSolutionLength;
        return this;
    }

    public WordsListAsAnagram create() {
        return new WordsListAsAnagram(
                        filteredWords,
                        numberOfCombinations,
                        anagramSolutionLettersMap,
                        anagramSolutionLength);
    }

    public List<List<String>> createWordsListAsAnagram() {

        List<List<String>> allCombinations = new LinkedList<List<String>>();
        combinationUtil(allCombinations, filteredWords, new String[numberOfCombinations],
                            0, filteredWords.size()-1, 0, numberOfCombinations,
                                anagramSolutionLettersMap, anagramSolutionLength);
        return allCombinations;
    }

    private void combinationUtil(List<List<String>> allCombinations, List<String> words, String[] data, int start,
                                 int end, int index, int length, Map<String, Integer> anagramSolutionLettersMap, int anagramSolutionLength) {

        if (index == length) {
            List<String> combination = new LinkedList<String>();
            for (int j=0; j<length; j++) {
                combination.add(data[j]);
            }

            String combinationString = combination.stream().collect(Collectors.joining(""));
            if (combinationString.length() == anagramSolutionLength) {

                Map<String, Integer> combinationLettersMap = Utils.createLettersMapFromWord(combinationString);
                if(AnagramUtils.areTheseWordsAnagrams(anagramSolutionLettersMap, combinationLettersMap)) {
                    allCombinations.add(combination);
                }
            }
            return;
        }

        for (int i=start; i<=end && end-i+1 >= length-index; i++) {
            data[index] = words.get(i);
            combinationUtil(allCombinations, words, data, i+1, end, index+1, length, anagramSolutionLettersMap, anagramSolutionLength);
        }
    }
}
