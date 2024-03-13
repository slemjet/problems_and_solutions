package us.slemjet.leetcode.easy.tasks_2451_2500;

/**
 * 2485. Find the Pivot Integer
 */
public class FindThePivotInteger {

    /**
     * Time: O(n)   ->  77.54%
     * Space:O(1)   ->  27.98%
     */
    public int pivotInteger(int n) {

        int left = 0;
        int right = n;
        int sum = right;

        while (left < right) {
            if (sum >= 0) {
                left++;
                sum -= left;
            } else {
                right--;
                sum += right;
            }
        }

        return sum == 0 ? left : -1;
    }
}
