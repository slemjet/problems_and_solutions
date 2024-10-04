package us.slemjet.leetcode.easy.tasks_251_300;

/**
 * 277. Find the Celebrity
 * tags: LinkedIn
 */
public class FindTheCelebrity {

    public static class Solution extends Relation {

        public Solution(int[][] graph) {
            super(graph);
        }

        /**
         * Do 2 rounds - find candidate, varify candidate
         * Time:    O(n)   ->  75.31%
         * Space:   O(1)   ->  49.82%
         */
        public int findCelebrity(int n) {

            // Find celebrity candidate
            int candidate = 0;
            for (int i = 0; i < n; i++) {
                if (knows(candidate, i)) {
                    // true -> candidate is not a celebrity
                    // false -> i is not a celebrity
                    candidate = i;
                }
            }

            // Verify if candidate is actually a celebrity by asking all again if they know
            for (int i = 0; i < n; i++) {
                if (i == candidate) continue; // always knows themselves

                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }

            return candidate;
        }

        /**
         * Brute Force
         * Time:    O(n^2)  ->  5.24%
         * Space:   O(n)    ->  50.25%
         */
        public int findCelebrityBrute(int n) {

            int[] known = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;

                    boolean knows = knows(i, j);
                    if (knows) known[j]++;
                    else known[j] = -1;
                }
            }

            for (int candidate = 0; candidate < n; candidate++) {
                if (known[candidate] == n - 1) {
                    for (int j = 0; j < n; j++) {
                        if (j == candidate) continue;

                        if (knows(candidate, j))
                            known[candidate] = -1;
                    }
                }
            }

            for (int candidate = 0; candidate < n; candidate++) {
                if (known[candidate] == n - 1) {
                    return candidate;
                }
            }

            return -1;
        }
    }

    private static class Relation {

        public Relation(int[][] graph) {
            this.graph = graph;
        }

        protected int[][] graph;

        boolean knows(int a, int b) {
            return graph[a][b] == 1;
        }
    }
}
