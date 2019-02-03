package updated.alice.solution;

import java.util.List;
import java.util.Map;

public class SearchThread implements Runnable {

    private List<String> combination;
    private Map<String, Integer> anagramSolutionLettersMap;
    private List<List<String>> allCombinations;
    private String combinationString;

    public SearchThread(List<String> combination, Map<String, Integer> anagramSolutionLettersMap, List<List<String>> allCombinations, String combinationString) {
        this.combination = combination;
        this.anagramSolutionLettersMap = anagramSolutionLettersMap;
        this.allCombinations = allCombinations;
        this.combinationString = combinationString;
    }

    @Override
    public void run() {

        Map<String, Integer> combinationLettersMap = Utils.createLettersMapFromWord(combinationString);
        if(AnagramUtils.areTheseWordsAnagrams(anagramSolutionLettersMap, combinationLettersMap)) {
            allCombinations.add(combination);
        }
    }
}