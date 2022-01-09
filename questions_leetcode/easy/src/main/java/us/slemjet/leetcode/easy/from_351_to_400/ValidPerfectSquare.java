package us.slemjet.leetcode.easy.from_351_to_400;

public class ValidPerfectSquare {

    /**
     * Use Newton's formula to guess answer
     *
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 36.3 MB, less than 29.43%
     */
    public boolean isPerfectSquareNewton(int num) {

        long candidate = num;

        while (candidate * candidate > num)
            candidate = (candidate + num / candidate) / 2;


        return candidate * candidate == num;
    }

    /**
     * Subtract odd numbers until n > 0. Since square is a sum of odd numbers
     * <p>
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 36.4 MB, less than 17.58%
     */
    public boolean isPerfectSquareSubstr(int num) {

        int sub = 1;

        while (num > 0) {
            num -= sub;
            sub += 2;
        }

        return num == 0;
    }

    /**
     * Use binary search t find candidate
     *
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 36.2 MB, less than 42.06%
     */
    public boolean isPerfectSquareBinary(int num) {

        int start = 1;
        int end = num;

        while (start <= end) {
            int candidate = start + (end - start) / 2;

            int division = num / candidate;
            int remainder = num % candidate;

            if (candidate == division && remainder == 0) { // equals without remainder - is square
                return true;
            }

            if (candidate >= division) { // candidate too big - decrease
                end = candidate - 1;
            } else { // candidate too small - increase
                start = candidate + 1;
            }
        }

        return false;
    }
}
