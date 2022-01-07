package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.Random;

/**
 * 384. Shuffle an Array
 */
public class ShuffleAnArray {

    /**
     * Runtime: 5.15%
     * Memory Usage: 24.01%
     */
    static class Solution {

        final private int[] nums;
        final private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] shuffled = new int[nums.length];
            for (int currIdx = 0; currIdx < shuffled.length; currIdx++) {
                int nextIdx = random.nextInt(currIdx + 1);
                shuffled[currIdx] = shuffled[nextIdx];
                shuffled[nextIdx] = nums[currIdx];
            }
            return shuffled;
        }
    }

    /**
     * Runtime: 12.61%
     * Memory Usage: 24.84%
     */
    static class Solution2 {

        final private int[] nums;
        final private Random random;

        public Solution2(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] shuffled = nums.clone();
            for (int currIdx = 0; currIdx < shuffled.length; currIdx++) {
                int bound = shuffled.length - currIdx;
                int nextIdx = currIdx + random.nextInt(bound);
                swap(shuffled, currIdx, nextIdx);
            }
            return shuffled;
        }

        private void swap(int[] shuffled, int currIdx, int nextIdx) {
            int tmp = shuffled[currIdx];
            shuffled[currIdx] = shuffled[nextIdx];
            shuffled[nextIdx] = tmp;
        }
    }
}
