package us.slemjet.leetcode.medium.tasks_851_900;

import java.util.*;

/**
 * 894. All Possible Full Binary Trees
 */
public class AllPossibleFullBinaryTrees {

    /**
     * Runtime: 78.97%
     * Memory Usage: 71.77%
     */
    public List<TreeNode> allPossibleFBT(int n) {

        Map<Integer, List<TreeNode>> trees = new HashMap<>();

        // Initial state
        trees.put(1, List.of(new TreeNode(0)));

        return generateTree(trees, n);
    }

    private List<TreeNode> generateTree(Map<Integer, List<TreeNode>> trees, int n) {
        if (!trees.containsKey(n)) {
            List<TreeNode> nodes = new ArrayList<>();
            if (n % 2 == 1) {

                for (int i = 0; i < n; i++) {
                    int j = n - i - 1;
                    // i - left index
                    // j - right index
                    // Generate all possible subtrees fo current node
                    for (TreeNode left : generateTree(trees, i)) {
                        for (TreeNode right : generateTree(trees, j)) {
                            // Compose new subtree from candidates and add to result
                            nodes.add(new TreeNode(0, left, right));
                        }
                    }
                }
            }
            trees.put(n, nodes);
        }

        return trees.get(n);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
