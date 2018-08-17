package updated.alice.solution;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 * Entry point to search solution
 */
public class EntryPoint {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        if (args.length == 0) {
            System.out.println("Please use: solution MD5 hash, " +
                    "solution anagram, " +
                    "path to words list, " +
                    "filter out words shorter than, default value 4 letters");
        } else {

            int minLengthOfWord;

            if (args.length == 3) {
                minLengthOfWord = 4;
            } else {
                minLengthOfWord = Integer.parseInt(args[3]);
            }

            List<String> words = Utils.readFile(args[2]);
            List<String> answers = new SearchSolution().search(args[1], words, args[0], minLengthOfWord);
            System.out.println("Answer: " + answers);
        }
    }
}
