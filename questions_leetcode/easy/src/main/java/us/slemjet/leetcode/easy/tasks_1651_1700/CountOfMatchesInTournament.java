package us.slemjet.leetcode.easy.tasks_1651_1700;

/**
 * 1688. Count of Matches in Tournament
 */
public class CountOfMatchesInTournament {

    /**
     * Time: O(n) -> 100.00%
     * Space: O(1) -> 31.59%
     */
    public int numberOfMatches(int n) {

        int result = 0;

        while (n > 1) {

            int extra = n % 2;

            n = n >> 1;
            result += n + extra;
        }

        return result;
    }

    /**
     * Time: O(n) -> 100.00%
     * Space: O(1) -> 31.59%
     */
    public int numberOfMatchesLogic(int n) {

        // Each team plays and loses one match except winner

        return n - 1;
    }
}
