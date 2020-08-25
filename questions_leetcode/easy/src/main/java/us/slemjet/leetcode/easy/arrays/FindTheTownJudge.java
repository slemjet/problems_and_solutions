package us.slemjet.leetcode.easy.arrays;

public class FindTheTownJudge {

    /**
     * Runtime: 3 ms, faster than 90.91%
     * Memory Usage: 47 MB, less than 87.92%
     */
    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0 && N == 1) {
            return 1;
        }

        int[] trusts = new int[N + 1];
        int[] trusted = new int[N + 1];

        int candidate = -1;
        for (int[] ints : trust) {
            int trustedToIdx = ints[1];
            trusts[trustedToIdx]++;
            trusted[ints[0]] = trustedToIdx;

            if (trusts[trustedToIdx] == N - 1) {
                candidate = trustedToIdx;
            }
        }

        if (candidate != -1 && trusted[candidate] == 0) {
            return candidate;
        }

        return -1;
    }
}
