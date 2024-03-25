package us.slemjet.leetcode.medium.tasks_401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 */
public class FindAllDuplicatesInAnArray {

    /**
     * Time: O(n)   ->  91.81%
     * Space: O(1)  ->  64.89%
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            num = num > 0 ? num : -num;
            if (nums[num - 1] < 0) {
                // Is already marked as visited -> add to result
                result.add(num);
            } else {
                // Mark as visited
                nums[num - 1] *= -1;
            }
        }

        return result;
    }
}
