package us.slemjet.leetcode.medium.tasks_901_950;

import java.util.Arrays;

/**
 * 948. Bag of Tokens
 */
public class BagOfTokens {

    /**
     *  Time: O(n)  ->  97.13%
     *  Space:O(1)  ->  57.01%
     */
    public int bagOfTokensScore(int[] tokens, int power) {

        int result = 0;

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {

            while (left <= right && power >= tokens[left]) {
                // Grab as many token as you can
                power -= tokens[left];
                result++;
                left++;
            }
            if (left < right && result > 0) {
                // Sell token for max power
                power += tokens[right];
                result--;
                right--;
            } else {
                // No more tokens to sell
                break;
            }
        }

        return result;
    }
}
