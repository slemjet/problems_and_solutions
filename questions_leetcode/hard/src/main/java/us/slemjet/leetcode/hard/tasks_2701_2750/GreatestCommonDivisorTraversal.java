package us.slemjet.leetcode.hard.tasks_2701_2750;

/**
 * 2709. Greatest Common Divisor Traversal
 */
public class GreatestCommonDivisorTraversal {

    /**
     *  Time: O()   ->  45.45%
     *  Space:O()   ->  50.91%
     */
    public boolean canTraverseAllPairs(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        // Populate list of prime numbers up to max of nums
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        for (int num : nums) {
            maxNumber = Math.max(maxNumber, num);
            minNumber = Math.min(minNumber, num);
        }
        if (minNumber == 1) {
            return false;
        }

        UnionFind unionFind = new UnionFind(maxNumber + 1);
        for (int num : nums) {
            // Apply sieve of Eratosthenes to get all divisible numbers
            for (int i = 2; i * i <= maxNumber; i++) {
                if (num % i == 0 && num / i != 1) {
                    unionFind.unite(num, i); // Join with this i
                    unionFind.unite(num, num / i); // Join with division by this i
                }
            }
        }

        // Go through the union and check if first node is connected with every number
        for (int num : nums) {
            if (!unionFind.isConnected(nums[0], num)) {
                return false;
            }
        }

        return true;
    }

    static class UnionFind {
        private final int[] parent;
        private final int[] ranks;

        public UnionFind(int n) {
            parent = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * Returns parent of current node
         */
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * Unites 2 nodes - x and y
         */
        public void unite(int x, int y) {

            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY) {
                // Unite by rank
                if (ranks[x] > ranks[y]) { // X has bigger rank
                    parent[parentY] = parentX;
                } else if (ranks[y] > ranks[x]) {
                    parent[parentX] = parentY; // Y has bigger rank
                } else {
                    parent[parentY] = parentX; // Equal ranks
                    ranks[parentX]++;
                }
            }
        }

        /**
         * Checks if two nodes are connected (have same parent)
         */
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void reset(int x) {
            parent[x] = x;
            ranks[x] = 0;
        }
    }
}
