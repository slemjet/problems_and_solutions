package us.slemjet.leetcode.medium.tasks_951_1000;

/**
 * 991. Broken Calculator
 */
public class BrokenCalculator {

    /**
     * Runtime: 100.00%
     * Memory Usage: 30.28%
     */
    public int brokenCalc(int startValue, int target) {

        int count = 0;

        while (startValue < target) {
            count++;
            if (target % 2 > 0) target++; // If cannot divide - add (subtract)
            else target /= 2; // It is faster to divide (greedy)
        }

        // "startValue - target" will cover startValue > target
        return count + startValue - target;
    }
}
