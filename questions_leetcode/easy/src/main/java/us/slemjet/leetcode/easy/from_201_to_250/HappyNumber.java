package us.slemjet.leetcode.easy.from_201_to_250;

/**
 * 202. Happy Number
 */
public class HappyNumber {

    /**
     * Runtime: 100.00%
     * Memory Usage: 66.78%
     */
    public boolean isHappy(int n) {

        boolean[] visited = new boolean[10];
        while (n > 3) {
            int next = 0;
            while (n > 0) {
                int pow = n % 10;
                next += pow * pow;
                n /= 10;
            }
            n = next;
            if (n < 10) {
                if (visited[n]) {
                    break;
                } else {
                    visited[n] = true;
                }
            }
        }

        return n == 1;
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 86.03%
     */
    public boolean isHappyAlt(int n) {
        // use 2 pointers to get loop
        int slow = n;
        int quick = n;
        while (slow > 1) {
            slow = calcPow(slow);
            if (slow == 1) return true;
            quick = calcPow(calcPow(quick));
            if (quick == 1) return true;
            // loop condition
            if (slow == quick) return false;
        }
        return true;
    }

    public int calcPow(int n) {
        int sumPow = 0;
        while (n > 0) {
            sumPow += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sumPow;
    }
}
