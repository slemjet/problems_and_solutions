package us.slemjet.leetcode.hard.tasks_100_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 140. Word Break II
 */
public class WordBreakII {

    /**
     * Runtime: 93.38%
     * Memory Usage: 73.43%
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        helper(0, s, new HashSet<>(wordDict), new ArrayList<>(), result);
        return result;
    }

    private void helper(int idx, String s, HashSet<String> wordDict, List<String> current, List<String> result) {
        if (idx == s.length()) {
            result.add(String.join(" ", current));
            return; // reached end
        }

        for (int i = idx + 1; i <= s.length(); i++) { // iterate over remaining part of string
            String candidate = s.substring(idx, i);
            if (wordDict.contains(candidate)) { // solution found
                current.add(candidate);
                int candIdx = current.size() - 1; // memorize candidate index
                helper(i, s, wordDict, current, result);
                // backtrack to check other variants
                current.remove(candIdx);
            }
        }
    }

    /**
     * Runtime: 66.44%
     * Memory Usage: 62.33%
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return backTrack(s, wordDict, new HashMap<>());
    }

    private List<String> backTrack(String s, List<String> wordDict, HashMap<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s); // Get from cache
        }

        List<String> result = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) { // solution
                String remaining = s.substring(word.length());

                if (remaining.length() == 0) {
                    result.add(word); // word is last in sequence
                } else {
                    List<String> remainingResults = backTrack(remaining, wordDict, mem);
                    for (String remainingResult : remainingResults) {
                        result.add(word + " " + remainingResult); // add combinations with all remaining words
                    }
                }
            }
        }

        mem.put(s, result);
        return result;
    }
}
