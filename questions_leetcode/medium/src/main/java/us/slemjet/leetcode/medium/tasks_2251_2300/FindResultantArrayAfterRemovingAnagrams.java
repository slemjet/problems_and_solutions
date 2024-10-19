package us.slemjet.leetcode.medium.tasks_2251_2300;

import java.util.ArrayList;
import java.util.List;

/**
 * 2273. Find Resultant Array After Removing Anagrams
 */
public class FindResultantArrayAfterRemovingAnagrams {

    /**
     * Time: O(n*m) ->  61.48%
     * Space:O(n)   ->  34.37%
     */
    public List<String> removeAnagrams(String[] words) {

        List<String> result = new ArrayList<>();

        String prev = "";

        for (String word : words) {
            if (prev.length() != word.length()) {
                result.add(word);
            } else {
                int[] counts = new int[26];
                for (int i = 0; i < word.length(); i++) {
                    counts[word.charAt(i) - 'a']++;
                    counts[prev.charAt(i) - 'a']--;
                }
                for (int count : counts) {
                    if (count != 0) {
                        result.add(word);
                        break;
                    }
                }
            }
            prev = word;
        }

        return result;
    }
}
