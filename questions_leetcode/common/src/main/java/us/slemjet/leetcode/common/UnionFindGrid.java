package us.slemjet.leetcode.common;

public class UnionFindGrid {
    private final int[] parent;
    private final int[] ranks;
    private final int rows;
    private final int cols;

    public UnionFindGrid(int rows, int cols) {
        int size = rows * cols;
        parent = new int[size];
        ranks = new int[size];
        this.rows = rows;
        this.cols = cols;

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private int getIndex(int row, int col) {
        return row * cols + col;
    }

    /**
     * Returns parent of current cell
     */
    public int find(int row, int col) {
        int idx = getIndex(row, col);
        if (parent[idx] != idx) {
            parent[idx] = find(parent[idx] / cols, parent[idx] % cols);
        }
        return parent[idx];
    }

    /**
     * Unites 2 cells - (row1, col1) and (row2, col2)
     */
    public void unite(int row1, int col1, int row2, int col2) {
        int root1 = find(row1, col1);
        int root2 = find(row2, col2);

        if (root1 != root2) {
            if (ranks[root1] > ranks[root2]) {
                parent[root2] = root1;
            } else if (ranks[root2] > ranks[root1]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                ranks[root1]++;
            }
        }
    }

    /**
     * Checks if two cells are connected (have same parent)
     */
    public boolean isConnected(int row1, int col1, int row2, int col2) {
        return find(row1, col1) == find(row2, col2);
    }

    /**
     * Resets the given cell to represent itself as its own parent
     */
    public void reset(int row, int col) {
        int idx = getIndex(row, col);
        parent[idx] = idx;
        ranks[idx] = 0;
    }
}