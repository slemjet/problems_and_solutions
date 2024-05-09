package us.slemjet.leetcode.medium.tasks_3051_3100;

import java.util.Arrays;

/**
 * 3075. Maximize Happiness of Selected Children
 */
public class MaximizeHappinessOfSelectedChildren {

    /**
     * Time: O(nlogn)   -> 97.44%
     * Space:O(n)       -> 77.94%
     */
    public long maximumHappinessSum(int[] happiness, int k) {

        long result = 0;

        Arrays.sort(happiness);

        int selected = 0;

        while (selected < happiness.length && selected < k) {
            int idx = happiness.length - 1 - selected; // Start from end as is sorted asc
            int currHappiness = happiness[idx] - selected; // Each selection decreases all next happiness
            if (currHappiness <= 0) {
                // No more happiness :)
                break;
            }
            result += currHappiness;
            selected++;
        }

        return result;
    }
}
