package us.slemjet.leetcode.medium.from_100_to_150;

/**
 * 134. Gas Station
 */
public class GasStation {

    /**
     * Runtime: 100.00%
     * Memory Usage: 92.22%
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int step = 0;
        int startIdx = 0;
        int endIdx = 0;

        int sum = 0;

        while (step < gas.length) {

            sum += gas[endIdx];
            sum -= cost[endIdx];
            endIdx++;
            step++;

            while (sum < 0 && step < gas.length) {
                // backtrack until enough fuel to proceed
                startIdx = --startIdx < 0 ? gas.length + startIdx : startIdx;
                step++;
                sum += gas[startIdx];
                sum -= cost[startIdx];
            }
        }

        return sum >= 0 ? startIdx : -1;
    }
}
