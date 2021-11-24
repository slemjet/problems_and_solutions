package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementBST {

    int result = 0;
    int count = 0;

    /**
     * Runtime: 100.00%
     * Memory Usage: 5.02%
     * Use DFS traversal to find k-th element
     */
    public int kthSmallest(TreeNode root, int k) {

        dfs(root, k);

        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) return; // reached leftmost element

        dfs(node.left, k); // keep going left until reach smallest element

        if (++count == k)
            result = node.val; // found result

        dfs(node.right, k); // backtrack right

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
    }

    /**
     * Use count of nodes structure to keep their number - update on any modification
     * Runtime: 49.10%
     * Memory Usage: 10.33%
     */
    public int kthSmallestNumber(TreeNode root, int k) {

        Map<Integer, Integer> subNodesCount = new HashMap<>();
        populateNumberOfSubNodes(root, subNodesCount);

        int result = kthSmallestNumber(root, k, subNodesCount);

        return result;
    }

    private int populateNumberOfSubNodes(TreeNode root, Map<Integer, Integer> subNodesCount) {
        if (root == null)
            return 0;

        int leftAmount = populateNumberOfSubNodes(root.left, subNodesCount);
        int rightAmount = populateNumberOfSubNodes(root.right, subNodesCount);
        int amount = leftAmount + 1 + rightAmount;
        subNodesCount.put(root.val, amount);

        return amount;
    }

    private int kthSmallestNumber(TreeNode node, int k, Map<Integer, Integer> subNodesCount) {
        if (node == null)
            return 0;

        if (node.left != null) {
            int leftCount = subNodesCount.get(node.left.val);
            if (leftCount >= k) { // proceed to the left
                return kthSmallestNumber(node.left, k, subNodesCount);
            }
            if (leftCount == k - 1) { // found match in the left node
                return node.val;
            }
            // proceed to the right as the amount to the left is less than needed (- all the left tail)
            return kthSmallestNumber(node.right, k - 1 - leftCount, subNodesCount);
        } else {
            if (k == 1) { // found match to the right
                return node.val;
            }
            // proceed to the right - 1 (current node)
            return kthSmallestNumber(node.right, k - 1, subNodesCount);
        }
    }
}
