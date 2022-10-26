package us.slemjet.leetcode.medium.tasks_1201_1250;

import java.util.*;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    /**
     * Runtime: 73.07%
     * Memory Usage: 60.57%
     */
    public int maxLength(List<String> arr) {

        List<String> results = new ArrayList<>();

        results.add("");

        for (String word : arr) {
            if (!isValid(word)) continue;

            List<String> tempResults = new ArrayList<>();
            for (String result : results) {
                String candidate = result + word;
                if (isValid(candidate)) tempResults.add(candidate);
            }
            results.addAll(tempResults);
        }

        String result = results.stream().max(Comparator.comparingInt(String::length)).orElse("");

        return result.length();
    }

    private boolean isValid(String word) {
        boolean[] setChars = new boolean[26];

        for (char letter : word.toCharArray()) {
            int index = letter - 'a';
            if (setChars[index]) return false;
            setChars[index] = true;
        }
        return true;
    }

    /**
     * TLE
     */
    public int maxLengthDfs(List<String> arr) {

        if (arr == null || arr.size() == 0) return 0;

        Map<String, Integer> memo = new HashMap<>();

        return dfs(arr, "", 0, memo);
    }

    private int dfs(List<String> arr, String path, int idx, Map<String, Integer> memo) {
        if (memo.containsKey(path)) return memo.get(path);

        if (!isValid(path)) return 0;

        int max = path.length();
        for (int i = idx; i < arr.size(); i++) {
            max = Math.max(max, dfs(arr, path + arr.get(i), idx + 1, memo));
        }
        memo.put(path, max);
        return max;
    }
}
