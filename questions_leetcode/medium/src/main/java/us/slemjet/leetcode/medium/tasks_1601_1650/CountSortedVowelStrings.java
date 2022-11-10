package us.slemjet.leetcode.medium.tasks_1601_1650;

/**
 * 1641. Count Sorted Vowel Strings
 */
public class CountSortedVowelStrings {

    /**
     * Runtime: 100.00%
     * Memory Usage: 13.98%
     *
     * Space: 1(n)
     * Time: O(n)
     */
    public int countVowelStrings(int n) {

        int a = 1, e = 1, i = 1, o = 1, u = 1;

        while (n-- > 1){
            // Each is sum of all after it
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }

    /**
     * Runtime: 59.11%
     * Memory Usage: 12.11%
     */
    public int countVowelStringsDp(int n) {
        Integer[][] memo = new Integer[n + 1][6];
        return count(n, 0, memo);
    }

    private int count(int n, int idx, Integer[][] memo) {
        if (n == 0) return 1;

        if (memo[n][idx] == null) {

            int count = 0;
            // There are 5 vowels: a, e, i, o, u
            for (int i = idx; i < 5; i++) {
                // Count sum of combinations with each of previous
                count += count(n - 1, i, memo);
            }
            memo[n][idx] = count;
        }

        return memo[n][idx];
    }
}
