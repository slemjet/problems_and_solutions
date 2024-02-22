package us.slemjet.leetcode.easy.tasks_951_1000;

/**
 * 997. Find the Town Judge
 */
public class FindTheTownJudge {

    /**
     * Time: O(n)   ->  99.85%
     * Space:O(n)   ->  21.53%
     */
    public int findJudge1Array(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return 1;
        }

        // Create relative scores
        int[] trustScores = new int[n + 1];

        for (int[] tr : trust) {
            trustScores[tr[0]]--;
            trustScores[tr[1]]++;
        }

        // Find judge - will have trust score from everyone except for himself
        for (int i = 0; i < trustScores.length; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Runtime: 3 ms, faster than 90.91%
     * Memory Usage: 47 MB, less than 87.92%
     */
    public int findJudge2Arrays(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) {
            return 1;
        }

        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];

        int candidate = -1;
        for (int[] ints : trust) {
            int trustedToIdx = ints[1];
            trusts[trustedToIdx]++;
            trusted[ints[0]] = trustedToIdx;

            if (trusts[trustedToIdx] == n - 1) {
                candidate = trustedToIdx;
            }
        }

        if (candidate != -1 && trusted[candidate] == 0) {
            return candidate;
        }

        return -1;
    }
}
