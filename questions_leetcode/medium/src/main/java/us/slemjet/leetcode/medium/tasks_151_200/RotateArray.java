package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 189. Rotate Array
 */
public class RotateArray {

    /**
     * Using 3 rotates
     * Runtime: 100.00%
     * Memory Usage: 60.27%
     */
    public void rotate(int[] nums, int k) {

        // Remove extra length
        k = k % nums.length;

        // [>,>,>,>,>>,>,>,>]
        // [<,<,<,<<,>,>,>,>]
        // [>,>,>,>>,>,>,>,>]

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    /**
     * Using next index formula and separate array
     * Runtime: 67.66%
     * Memory Usage: 70.09%
     */
    public void rotateSeparate(int[] nums, int k) {
        int l = nums.length;
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int nextIdx = (i + k) % l;
            rotated[nextIdx] = nums[i];
        }

        System.arraycopy(rotated, 0, nums, 0, rotated.length);
    }
}
