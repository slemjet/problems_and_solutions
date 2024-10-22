package us.slemjet.leetcode.medium.tasks_151_200;

import us.slemjet.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {

    /**
     * Time:O(n)    ->  66.70%
     * Space:O(n)   ->  9.59%
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1)
                    result.add(poll.val);
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }
        }

        return result;
    }

    /**
     * Time: O(n)   ->  100.00%
     * Space:O(n)   ->  79.10%
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        rightSideViewDFS(root, result, 0);
        return result;
    }

    private void rightSideViewDFS(TreeNode node, List<Integer> result, int level) {
        if (level == result.size()) {
            result.add(node.val);
        }
        // traverse right first so right side is populated first
        if (node.right != null) {
            rightSideViewDFS(node.right, result, level + 1);
        }
        if (node.left != null)
            rightSideViewDFS(node.left, result, level + 1);

    }
}
