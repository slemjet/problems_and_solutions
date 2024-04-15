package us.slemjet.leetcode.medium.tasks_101_150;

import us.slemjet.leetcode.common.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRootToLeafNumbers {

    /**
     * Time: O(n)   ->  100%
     * Space:O(n)   ->  41.25%
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currSum) {

        int sum = 0;
        if (root == null) {
            return sum;
        }

        currSum = currSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            // leaf node
            sum += currSum;
        } else {
            sum += sumNumbers(root.left, currSum);
            sum += sumNumbers(root.right, currSum);
        }

        return sum;
    }
}
