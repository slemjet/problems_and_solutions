package us.slemjet.leetcode.easy.from_0_to_50;

public class ReverseInteger {

    public int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int nextDigit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + nextDigit;
            x /= 10;
        }
        return result;
    }
}
