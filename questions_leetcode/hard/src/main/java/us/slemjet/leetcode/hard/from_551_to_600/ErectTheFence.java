package us.slemjet.leetcode.hard.from_551_to_600;

import java.util.*;

/**
 * 587. Erect the Fence
 */
public class ErectTheFence {

    /**
     * Monotonous chain
     * <p>
     * Create a stack.
     * Go left to right add tree if it is least counterclockwise
     * Go right to lest and repeat process
     * <p>
     * Runtime: 68.97%
     * Memory Usage: 93.10%
     * <p>
     * Space: O(n)
     * Time: O(n)
     */
    public int[][] outerTreesMonotonousChain(int[][] trees) {

        if (trees.length < 4) return trees;

        List<int[]> treeList = Arrays.asList(trees);

        // 1. Sort left x to right
        treeList.sort(Comparator.comparingInt((int[] tree) -> tree[0]).thenComparingInt(tree -> tree[1]));

        Stack<int[]> leftToRight = new Stack<>();
        // 2. Populate stack left to right
        for (int i = 0; i < treeList.size(); i++) {
            int[] next = treeList.get(i);
            // Remove if next point is less counterclockwise
            while (leftToRight.size() >= 2 && crossProduct(leftToRight.get(leftToRight.size() - 2), leftToRight.get(leftToRight.size() - 1), next) > 0) {
                leftToRight.pop();
            }
            leftToRight.push(next);
        }

        Stack<int[]> rightToLeft = new Stack<>();
        // 3. Populate stack right to left
        for (int i = treeList.size() - 1; i >= 0; i--) {
            int[] next = treeList.get(i);
            while (rightToLeft.size() >= 2 && crossProduct(rightToLeft.get(rightToLeft.size() - 2), rightToLeft.get(rightToLeft.size() - 1), next) > 0) {
                rightToLeft.pop();
            }
            rightToLeft.push(next);
        }

        Set<int[]> result = new HashSet<>();
        result.addAll(leftToRight);
        result.addAll(rightToLeft);

        return result.toArray(new int[result.size()][]);
    }

    /**
     * > 0 -> counterclockwise (lower)
     * < 0 -> clockwise (upper)
     * == 0: collinear
     */
    private int crossProduct(int[] p1, int[] p2, int[] p3) {
        // | (P2[0], P3[0]) (P2[0], P1[0]) |
        // | (P2[1], P3[1]) (P2[1], P1[1]) |
        return (p3[0] - p2[0]) * (p2[1] - p1[1]) - (p3[1] - p2[1]) * (p2[0] - p1[0]);
    }

    /**
     * Graham scan algorithm
     * Sort, Split into lower and upper part and scan both
     *
     * Runtime: 17.74%
     * Memory Usage: 53.23%
     */
    public int[][] outerTreesGraham(int[][] trees) {

        if (trees.length < 4) return trees;

        List<int[]> treeList = Arrays.asList(trees);

        // 1. Sort left x to right
        treeList.sort(Comparator.comparingInt((int[] tree) -> tree[0]).thenComparingInt(tree -> tree[1]));

        List<int[]> lower = new ArrayList<>();
        List<int[]> upper = new ArrayList<>();

        for (int[] tree : trees) {
            while (lower.size() >= 2 && crossProduct(lower.get(lower.size() - 2), lower.get(lower.size() - 1), tree) > 0) {
                // Lower part goes most counterclockwise direction
                lower.remove(lower.size() - 1);
            }
            while (upper.size() >= 2 && crossProduct(upper.get(upper.size() - 2), upper.get(upper.size() - 1), tree) < 0) {
                // Upper part goes most clockwise direction
                upper.remove(upper.size() - 1);
            }

            lower.add(tree);
            upper.add(tree);
        }


        Set<int[]> result = new HashSet<>();
        result.addAll(lower);
        result.addAll(upper);

        return result.toArray(new int[result.size()][]);
    }


    /**
     * Jarvis algorithm
     * TLE
     */
    public int[][] outerTreesJarvis(int[][] trees) {

        if (trees.length < 4) return trees;

        HashSet<int[]> hull = new HashSet<>();
        int leftMostIdx = 0;
        for (int i = 0; i < trees.length; i++)
            if (trees[i][0] < trees[leftMostIdx][0])
                leftMostIdx = i;
        int p = leftMostIdx;

        do {
            int q = (p + 1) % trees.length;
            for (int i = 0; i < trees.length; i++) {
                if (orientation(trees[p], trees[i], trees[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < trees.length; i++) {
                if (i != p && i != q && orientation(trees[p], trees[i], trees[q]) == 0 && inBetween(trees[p], trees[i], trees[q])) {
                    hull.add(trees[i]);
                }
            }
            hull.add(trees[q]);
            p = q;
        }
        while (p != leftMostIdx);

        return hull.toArray(new int[hull.size()][]);
    }

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public boolean inBetween(int[] p, int[] i, int[] q) {
        boolean a = i[0] >= p[0] && i[0] <= q[0] || i[0] <= p[0] && i[0] >= q[0];
        boolean b = i[1] >= p[1] && i[1] <= q[1] || i[1] <= p[1] && i[1] >= q[1];
        return a && b;
    }
}
