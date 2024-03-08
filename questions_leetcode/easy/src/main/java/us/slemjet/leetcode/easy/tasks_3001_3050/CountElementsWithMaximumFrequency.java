package us.slemjet.leetcode.easy.tasks_3001_3050;

/**
 * 3005. Count Elements With Maximum Frequency
 */
public class CountElementsWithMaximumFrequency {

    /**
     * Time: O(n)   ->  99.64%
     * Space:O(n)   ->  88.71%
     */
    public int maxFrequencyElements(int[] nums) {

        int[] counts = new int[101];

        int result = 0;
        int max = 0;

        for (int num : nums) {
            counts[num]++;
            max = Math.max(max, counts[num]);
        }

        for (int count : counts) {
            if (count == max) {
                result += max;
            }
        }

        return result;
    }
}
