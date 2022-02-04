package us.slemjet.leetcode.medium.tasks_1451_1500;

/**
 * 1492. The kth Factor of n
 */
public class TheKthFactorOfN {

    /**
     * Runtime: 77.69%
     * Memory Usage: 5.77%
     */
    public int kthFactor(int n, int k) {

        int curr = 0;

        while (curr <= n) {
            if (n % ++curr == 0 && --k == 0) return curr;
        }

        return -1;
    }
}
