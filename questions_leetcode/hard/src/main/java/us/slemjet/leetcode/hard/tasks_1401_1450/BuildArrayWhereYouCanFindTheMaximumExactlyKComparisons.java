package us.slemjet.leetcode.hard.tasks_1401_1450;

/**
 * 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
 */
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {

    /**
     * Top To Bottom approach
     *
     * Time: O(n*m^2*k)    -> 40.92%
     * Space:O(n*m*k)      -> 61.67%
     */
    public int numOfArraysTopToBottom(int n, int m, int k) {

        int modulo = (int) (Math.pow(10, 9) + 7);
        Integer[][][] memo = new Integer[n + 1][m + 1][k + 1];

        return numOfArrays(0, 0, 0, n, m, k, modulo, memo);
    }

    private int numOfArrays(int currN, int currM, int currK, int n, int m, int k, int modulo, Integer[][][] memo) {

        if (currN == n) {
            if (currK == k) {
                return 1; // Solution
            } else {
                return 0; // No Solution
            }
        }

        if (currK > k) {
            return 0; // Too many moves - no Solution
        }

        if (memo[currN][currM][currK] != null) {
            return memo[currN][currM][currK];
        }

        int result = 0;

        for (int number = 1; number <= currM; number++) {
            //  Try to add new number that is less than current max
            result = (result + numOfArrays(currN + 1, currM, currK, n, m, k, modulo, memo)) % modulo;
        }

        for (int number = currM + 1; number <= m; number++) {
            //  Try to add number that is a new max - we increment k
            result = (result + numOfArrays(currN + 1, number, currK + 1, n, m, k, modulo, memo)) % modulo;
        }

        return memo[currN][currM][currK] = result;
    }

    /**
     * Top To Bottom Approach
     *
     * Time: O(n*m^2*k)    -> 12.10%
     * Space:O(n*m*k)      -> 24.50%
     */
    public int numOfArraysBottomUp(int n, int m, int k) {

        int modulo = (int) (Math.pow(10, 9) + 7);
        int[][][] dp = new int[n + 1][m + 1][k + 1];

        // Initialize base case
        for (int num = 0; num <= m; num++) {
            dp[n][num][0] = 1; // Reached end with exact k - new combination
        }

        for (int count = n - 1; count >= 0; count--) {
            for (int num = m; num >= 0; num--) {
                for (int cost = 0; cost <= k; cost++) {

                    for (int number = 1; number <= num; number++) {
                        //  Add new number that is less than current max
                        dp[count][num][cost] = (dp[count][num][cost] + dp[count + 1][num][cost]) % modulo;
                    }

                    if (cost == 0) {
                        continue; // Cannot add new max
                    }
                    for (int number = num + 1; number <= m; number++) {
                        //  Add number that is a new max - we increment k
                        dp[count][num][cost] = (dp[count][num][cost] + dp[count + 1][number][cost - 1]) % modulo;
                    }
                }
            }
        }

        return dp[0][0][k];
    }
}
