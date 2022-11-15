package us.slemjet.leetcode.medium.tasks_901_950;

/**
 * 947. Most Stones Removed with Same Row or Column
 */
public class MostStonesRemovedWithSameRowOrColumn {

    /**
     * Result is total number of stones - number of stones, that can be connected to each other
     * thus forming an island of connected stones
     * <p>
     * Runtime: 19.44%
     * Memory Usage: 81.39%
     * <p>
     * Space: O(n)
     * Time: O(n^2)
     */
    public int removeStonesDfs(int[][] stones) {

        // Mark visited stones
        boolean[] visited = new boolean[stones.length];

        // Island is stones, connected vertically or horizontally
        int islands = 0;
        for (int i = 0; i < stones.length; i++) {
            if (visited[i]) continue;

            // Check if current stone can be linked to others
            dfs(stones[i], visited, stones);
            visited[i] = true;
            islands++;
        }

        return stones.length - islands;
    }

    private void dfs(int[] stone, boolean[] visited, int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] && (stone[0] == stones[i][0] || stone[1] == stones[i][1])) {
                visited[i] = true;
                // Linking to another stone and check it
                dfs(stones[i], visited, stones);
            }
        }
    }

    /**
     * Runtime: 78.42%
     * Memory Usage: 93.46%
     */
    public int removeStonesUnionFind(int[][] stones) {
        int[] unions = new int[1000];

        for (int i = 0; i < stones.length; i++) {
            // Populate initial groups - 1 for each element
            unions[i] = i;
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    // If this criteria is fulfilled - join group
                    union(i, j, unions);
            }
        }

        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            // Number of groups (unique)
            if (unions[i] == i) count++;
        }

        return stones.length - count;
    }

    private void union(int i, int j, int[] unions) {
        i = find(i, unions);
        j = find(j, unions);
        if (i == j) return;
        // Add to group (i - representative)
        unions[j] = i;
    }

    private int find(int i, int[] unions) {
        if (unions[i] == i) return i;
        return find(unions[i], unions);
    }
}
