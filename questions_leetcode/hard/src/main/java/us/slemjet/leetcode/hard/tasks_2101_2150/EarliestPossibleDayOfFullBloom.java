package us.slemjet.leetcode.hard.tasks_2101_2150;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2136. Earliest Possible Day of Full Bloom
 */
public class EarliestPossibleDayOfFullBloom {

    /**
     * Runtime: 87.39%
     * Memory Usage: 93.24%
     *
     * Space: O(n)
     * Time: O(n)
     */
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        List<int[]> plants = new ArrayList<>();

        for (int i = 0; i < plantTime.length; i++) {
            plants.add(new int[]{plantTime[i], growTime[i]});
        }

        // Sort plants by growTime descending -> we need to plant those with max growTime first
        plants.sort(Comparator.comparingInt((int[] o) -> o[1]).reversed());

        int sumPlantTime = 0;
        int maxBloomTime = 0;

        for (int[] plant : plants) {
            int currBloomTime = sumPlantTime + plant[0] + plant[1];
            maxBloomTime = Math.max(maxBloomTime, currBloomTime);
            sumPlantTime += plant[0];
        }

        return maxBloomTime;
    }

}
