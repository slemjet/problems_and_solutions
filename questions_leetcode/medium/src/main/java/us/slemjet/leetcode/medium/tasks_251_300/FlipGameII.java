package us.slemjet.leetcode.medium.tasks_251_300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 294. Flip Game II
 */
public class FlipGameII {

    /**
     * Time:    O() ->  41.71%
     * Space:   O() ->  6.03%
     */
    public boolean canWin(String currentState) {
        Map<String, Boolean> memo = new HashMap<>();
        return canWin(currentState.toCharArray(), memo);
    }

    private boolean canWin(char[] chars, Map<String, Boolean> memo) {

        String memoKey = Arrays.toString(chars);
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && chars[i] == '+') {
                chars[i] = chars[i - 1] = '-';
                // Make move
                boolean canWin = canWin(chars, memo);
                // Backtrack
                chars[i] = chars[i - 1] = '+';
                if (!canWin) {
                    memo.put(memoKey, true);
                    return true;
                }
            }
        }
        memo.put(memoKey, false);
        return false;
    }
}
