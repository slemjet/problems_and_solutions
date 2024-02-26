package us.slemjet.leetcode.easy.tasks_51_100;

import us.slemjet.leetcode.common.TreeNode;

/**
 * 100. Same Tree
 */
public class SameTree {

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(1)   ->  41.74%
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == null && q == null;
        }

        return isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
    }
}
