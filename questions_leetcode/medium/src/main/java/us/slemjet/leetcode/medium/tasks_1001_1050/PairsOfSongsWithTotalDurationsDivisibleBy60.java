package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /**
     * Time: O(n)   ->  84.65%
     * Space:O(n)   ->  75.77%
     */
    public int numPairsDivisibleBy60(int[] time) {

        int result = 0;

        int[] remainderCounts = new int[60];

        for (int t : time) {
            int remainder = t % 60;
            int complement = (remainder == 0) ? 0 : 60 - remainder;
            // When we add a number - we calculate combinations with all remainders
            result += remainderCounts[complement];
            remainderCounts[remainder]++;
        }

        return result;
    }
}
