package us.slemjet.leetcode.string_to_integer;

public class Solution {

    public int atoi(String str) {

        str = str.trim();

        if (str.isEmpty())
            return 0;

        int signum = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (result == 0 && (c == '-') || c == '+') {
                if (signum != 0) {
                    return result;
                }
                if (c == '-')
                    signum = -1;
                else signum = 1;
                continue;
            }

            if (Character.isDigit(c)) {
                if (signum == 0)
                    signum = 1;

                int addition = Integer.parseInt(c + "") * signum;
                if (result != 0) {
                    if (result > Integer.MAX_VALUE / 10 ||
                            (result == Integer.MAX_VALUE / 10 && addition > Integer.MAX_VALUE % 10)) {
                        return Integer.MAX_VALUE;
                    } else if (result < Integer.MIN_VALUE / 10 ||
                            (result == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > addition)) {
                        return Integer.MIN_VALUE;
                    } else {
                        result *= 10;
                    }
                }
                result += addition;

            } else
                return result;

        }
        return result;
    }
}
