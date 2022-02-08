package us.slemjet.leetcode.easy.from_251_to_300;

/**
 * 258. Add Digits
 */
public class AddDigits {

    /**
     * Use digital root formula
     * <p>
     * Runtime: 59.15%
     * Memory Usage: 5.27%
     */
    public int addDigitsMath(int num) {

        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        else return num % 9;
    }

    /**
     *
     * Runtime: 59.15%
     * Memory Usage: 5.27%
     */
    public int addDigits(int num) {

        int nextNum = 0;
        while (num > 9) {
            while (num > 0) {
                nextNum += num % 10;
                num /= 10;
            }
            num = nextNum;
            nextNum = 0;
        }
        return num;
    }
}
