package us.slemjet.leetcode.medium.tasks_701_750;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 */
public class DailyTemperatures {

    /**
     * Time: O(n)   ->  57.84%
     * Space:O(n)   ->  84.01%
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        // int[]{temperature, index}
        Stack<int[]> nonIncreasingTemps = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            int nextTemperature = temperatures[i];

            while (!nonIncreasingTemps.isEmpty() && nonIncreasingTemps.peek()[0] < nextTemperature) {
                // Remove from stack until we reach bigger value
                int[] lowerTemperature = nonIncreasingTemps.pop();
                result[lowerTemperature[1]] = i - lowerTemperature[1];
            }
            nonIncreasingTemps.push(new int[]{nextTemperature, i});
        }

        // Remaining temperatures are in decreasing order and will not have a higher temperature therefore will remain with 0
        return result;
    }
}
