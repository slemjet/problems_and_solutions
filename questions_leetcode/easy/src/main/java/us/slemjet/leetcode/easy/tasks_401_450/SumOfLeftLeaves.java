package us.slemjet.leetcode.easy.tasks_401_450;

import us.slemjet.leetcode.common.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class SumOfLeftLeaves {

    /**
     * Time: O(n)   ->  100.00%
     * Space: O(n)  ->  46.01%
     */
    public int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;

        if (root == null) {
            return 0;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            // Left subnode is leaf
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }

        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
