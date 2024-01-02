package us.slemjet.leetcode.medium.tasks_2601_2650;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. Convert an Array Into a 2D Array With Conditions
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {

    /**
     * Time: O(n)   ->  55.08%
     * Space:O(n)   ->  50.21%
     */
    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Initialize list
        result.add(new ArrayList<>());

        int[] countByNumber = new int[nums.length + 1];

        for (int value : nums) {
            // Get count (index) of next value location
            int count = countByNumber[value];

            while (result.size() < count + 1) {
                result.add(new ArrayList<>());
            }

            result.get(count).add(value);
            // Update count so it will point to next value list
            countByNumber[value]++;
        }

        return result;
    }
}
