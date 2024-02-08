package us.slemjet.leetcode.easy.tasks_51_100;

public class SqrtX {

    /**
     * Use binary search to find results
     * Runtime: 100.00%
     * Memory Usage: 62.78%
     */
    public int mySqrt(int x) {

        if (x == 0) return 0;

        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x / mid >= mid && x / (mid + 1) < (mid + 1))
                // Check if result is found mid * mid = x
                return mid;

            if (x / mid > mid)
                // Result too small
                left = mid + 1;
            else
                // Result too big
                right = mid;

        }
        return left;
    }
}
