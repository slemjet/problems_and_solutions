package us.slemjet.leetcode.medium.tasks_1551_1600;

import java.util.Arrays;

/**
 * 1561. Maximum Number of Coins You Can Get
 */
public class MaximumNumberOfCoinsYouCanGet {

    /**
     * Time: O(nlogn) -> 98.94%
     * Space: O(n) -> 61.66%
     */
    public int maxCoins(int[] piles) {

        int result = 0;

        Arrays.sort(piles);

        // Lowest third - goes to Bob
        // For us - we maximize second elements in each pair, since Larges one goes to Alice
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            result += piles[i];
        }

        return result;
    }
}
