package us.slemjet.leetcode.medium.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    /**
     * Runtime:  100.00%
     * Memory Usage: 100.00%
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort to put all duplicates after each other
        List<List<Integer>> result = new ArrayList<>();
        // additional list to store number already used in combinations
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> solution, int[] nums, boolean[] used) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // check condition if we need to skip combination with this number
            // skip is current is used or all next are duplicates
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // work with next number
            used[i] = true;
            solution.add(nums[i]);
            backtrack(result, solution, nums, used);
            // combination added recursively - revert this flow and try with another number
            used[i] = false;
            solution.remove(solution.size() - 1);
        }
    }
}
