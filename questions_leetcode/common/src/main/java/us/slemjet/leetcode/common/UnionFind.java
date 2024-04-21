package us.slemjet.leetcode.common;

public class UnionFind {
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
