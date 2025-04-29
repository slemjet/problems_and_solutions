package us.slemjet.leetcode.easy.tasks_3351_3400;

/**
 * 3386. Button with Longest Push Time
 */
public class ButtonWithLongestPushTime {

    /**
     * Time:    O(n)    ->  100.00%
     * Space:   O(1)    ->  77.30
     */
    public int buttonWithLongestTime(int[][] events) {

        int result;

        int maxTime = events[0][1];
        result = events[0][0];

        for (int i = 1; i < events.length; i++) {
            int currTime = events[i][1] - events[i - 1][1];

            if (currTime > maxTime) {
                maxTime = currTime;
                result = events[i][0];
            } else if (currTime == maxTime) {
                result = Math.min(result, events[i][0]);
            }
        }

        return result;
    }
}
