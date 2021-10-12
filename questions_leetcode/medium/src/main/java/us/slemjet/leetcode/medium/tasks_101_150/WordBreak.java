package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 */
public class WordBreak {

    /**
     * Dynamic Programming
     * Runtime: 93.17%
     * Memory Usage: 84.76%
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // contain indices at which word can be split using existing dictionary

        dp[0] = true; // Set initial value to true as a starting point (empty string)
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    if (dp[i - word.length()]) { // if beginning of the word was also break
                        if (s.substring(i - word.length(), i).equals(word)) {
                            dp[i] = true; // word match - can break at this index
                            break; // no need to check other words
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * Runtime: 63.26%
     * Memory Usage: 21.87%
     */
    public boolean wordBreakDp2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || dp[j - 1]){
                    if(wordDict.contains(s.substring(j, i + 1))){
                        dp[i] = true;
                    }
                }
                
            }
        }
        return dp[s.length() - 1];
    }

    /**
     * Runtime: 81.55%
     * Memory Usage: 21.87%
     */
    public boolean wordBreakDFS(String s, List<String> wordDict) {
        Boolean[] mem = new Boolean[s.length()];
        return helper(0, s, new HashSet<String>(wordDict), mem);
    }

    private boolean helper(int idx, String s, HashSet<String> wordDict, Boolean[] mem) {
        if (idx == s.length()) {
            return true; // reached end
        }

        if (mem[idx] != null) {
            return mem[idx];
        }

        for (int i = idx + 1; i <= s.length(); i++) { // iterate over remaining part of string
            if (wordDict.contains(s.substring(idx, i)) && helper(i, s, wordDict, mem)) {
                // solution found
                return mem[idx] = true;
            }
        }

        return mem[idx] = false;
    }

    /***
     * Runtime: 76.45%
     * Memory Usage: 44.96%
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> memoSet = new HashSet<>();
        return wordBreakRec(s, new HashSet<>(wordDict), memoSet);
    }

    boolean wordBreakRec(String s, Set<String> wordDictSet, Set<String> memoSet) {
        if (memoSet.contains(s)) return false;
        if (wordDictSet.contains(s)) return true;

        for (int i = 1; i <= s.length(); i++)
            if (wordDictSet.contains(s.substring(0, i)) && wordBreakRec(s.substring(i), wordDictSet, memoSet))
                return true;

        memoSet.add(s);
        return false;
    }
}
