package us.slemjet.leetcode.medium.tasks_301_350;

/**
 * 333. Largest BST Subtree
 */
public class LargestBSTSubtree {

    /**
     * Time:    ->  100.00%
     * Space:   ->  74.91%
     */
    public int largestBSTSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (isBST(root, null, null)) {
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min || max != null && root.val >= max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public int largestBSTSubtreePostorder(TreeNode root) {

        return traversePostorder(root).count;
    }

    /**
     * Traverse postorder and store subTree metadata - max, min and count of nodes
     *
     * Time: O(n)    ->  100.00%
     * Space:O(n)    ->  74.91%
     */
    private TreeData traversePostorder(TreeNode root) {
        if (root == null) {
            // Empty node stub - with min bounds, so it can be included to any count
            return new TreeData(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        TreeData leftSubtree = traversePostorder(root.left);
        TreeData rightSubtree = traversePostorder(root.right);

        if (leftSubtree.max < root.val && rightSubtree.min > root.val) {
            // Is a valid BST
            int min = Math.min(leftSubtree.min, root.val);
            int max = Math.max(rightSubtree.max, root.val);
            int count = 1 + leftSubtree.count + rightSubtree.count;

            return new TreeData(min, max, count);
        }

        // Return whichever is bigger count with max bounds because it is not a valid BST
        return new TreeData(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(leftSubtree.count, rightSubtree.count));

    }

    public static class TreeData {
        int min;
        int max;
        int count;

        public TreeData(int min, int max, int count) {
            this.min = min;
            this.max = max;
            this.count = count;
        }
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
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
