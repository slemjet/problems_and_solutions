package us.slemjet.leetcode.medium.tasks_1101_1150;

import us.slemjet.leetcode.common.TreeNode;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves
 */
public class LowestCommonAncestorOfDeepestLeaves {

    int maxDepth = 0;
    TreeNode answer = null;

    /**
     * Time:    O(N)  ->  100%
     * Space:   O(N)  ->  29.33%
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        // Use postorder
        answer = root;
        postorder(root, 0);

        return answer;
    }

    private int postorder(TreeNode root, int currDepth) {

        if (root == null) {
            return currDepth;
        }

        int leftDepth = postorder(root.left, 1 + currDepth);
        int rightDepth = postorder(root.right, 1 + currDepth);

        int max = Math.max(leftDepth, rightDepth);
        maxDepth = Math.max(maxDepth, max);

        if (maxDepth == leftDepth && maxDepth == rightDepth) {
            answer = root;
        }

        return max;
    }

    /**
     * Time:    O(N)  ->  100%
     * Space:   O(N)  ->  29.33%
     */
    public TreeNode lcaDeepestLeaves2(TreeNode root) {

        return (TreeNode) postorder2(root)[1];
    }

    private Object[] postorder2(TreeNode root) {

        if (root == null) {
            return new Object[]{0, null};
        }

        Object[] left = postorder2(root.left);
        Object[] right = postorder2(root.right);

        int leftDepth = (Integer) left[0];
        int rightDepth = (Integer) right[0];

        if (leftDepth > rightDepth) {
            return new Object[]{leftDepth + 1, left[1]};
        }
        if (leftDepth < rightDepth) {
            return new Object[]{rightDepth + 1, right[1]};
        }

        return new Object[]{leftDepth + 1, root};
    }
}
