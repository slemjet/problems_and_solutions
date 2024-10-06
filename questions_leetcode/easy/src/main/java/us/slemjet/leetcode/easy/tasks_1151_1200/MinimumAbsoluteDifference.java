package us.slemjet.leetcode.easy.tasks_1151_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 */
public class MinimumAbsoluteDifference {

    /**
     * Time: O(nlogn)   ->  69.43%
     * Space:O(n)       ->  59.02%
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(diff, minDiff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}
