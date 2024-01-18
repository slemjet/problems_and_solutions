package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 */
public class LargestDivisibleSubset {

    /**
     * Time: O(n^2) ->  26.54%
     * Space:O(n)   ->  5.04%
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        // Max subset for current index
        List<List<Integer>> maxSubsets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            maxSubsets.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> currMaxSubset = new ArrayList<>();

            // Search among previous subsets for largest divisible one
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // Can form subset
                    if (maxSubsets.get(j).size() > currMaxSubset.size()) {
                        // Update for longest
                        currMaxSubset = maxSubsets.get(j);
                    }
                }
            }

            // Add subset for current number - need to be careful to not update shared list
            maxSubsets.get(i).addAll(currMaxSubset);
            maxSubsets.get(i).add(nums[i]);
        }

        List<Integer> maxSubset = maxSubsets.stream().max(Comparator.comparingInt(List::size)).orElse(List.of());

        return maxSubset;
    }
}
