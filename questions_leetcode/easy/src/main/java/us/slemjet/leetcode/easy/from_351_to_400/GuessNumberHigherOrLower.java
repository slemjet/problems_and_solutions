package us.slemjet.leetcode.easy.from_351_to_400;

/**
 * 374. Guess Number Higher or Lower
 *
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */
public class GuessNumberHigherOrLower {

    int number = 0;

    public GuessNumberHigherOrLower(int number) {
        this.number = number;
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 60.91%
     *
     * Space: O(1)
     * Time: O(logn)
     */
    public int guessNumber(int n) {

        // Use binary search to find number
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Candidate
            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1; // Result is smaller
            } else {
                low = mid + 1; // Result is bigger
            }
        }
        return -1;
    }

    int guess(int num) {
        return Integer.compare(number, num);
    }
}
