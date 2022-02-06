package us.slemjet.leetcode.medium.tasks_2051_2100;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100. Find Good Days to Rob the Bank
 */
public class FindGoodDaysToRobTheBank {

    /**
     * Store number of days, decreasing before current and increasing after current
     * Check if both are >- time for current day -> add this day
     *
     * Runtime: 55.50%
     * Memory Usage: 49.90%
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        List<Integer> result = new ArrayList<>();

        int[] decreasingBefore = new int[security.length];
        int[] increasingAfter = new int[security.length];

        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) {
                decreasingBefore[i] = decreasingBefore[i - 1] + 1;
            }
        }

        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                increasingAfter[i] = increasingAfter[i + 1] + 1;
            }
        }

        for (int i = time; i < security.length - time; i++) {
            // Check if there is enough days before and after
            if (decreasingBefore[i] >= time && increasingAfter[i] >= time) {
                result.add(i);
            }
        }

        return result;
    }
}
