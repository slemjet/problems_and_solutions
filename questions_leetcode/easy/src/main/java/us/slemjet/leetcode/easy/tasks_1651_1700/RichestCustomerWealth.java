package us.slemjet.leetcode.easy.tasks_1651_1700;

/**
 * 1672. Richest Customer Wealth
 */
public class RichestCustomerWealth {

    /**
     * Runtime: 100.00%
     * Memory Usage: 5.42%
     */
    public int maximumWealth(int[][] accounts) {

        int max = 0;
        for (int i = 0; i < accounts[0].length; i++) {
            for (int j = 0; j < accounts.length; j++) {
                if (i > 0) accounts[j][i] += accounts[j][i - 1];
                if (i == accounts[0].length - 1) max = Math.max(max, accounts[j][i]);
            }
        }
        return max;
    }
}
