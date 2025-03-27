package us.slemjet.leetcode.easy.tasks_251_300;

import us.slemjet.leetcode.common.TreeNode;

import java.util.*;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {

    /**
     * Time:    ->  65.04% -> O(n) Each node is visited exactly once in the stack operations.
     * Space:   ->  76.83% -> O(h + n) O(h) for the max recursion stack depth and O(n) for the 'visited' set and 'stack'.
     */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        // Initial state
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();

            if (peek.left == null && peek.right == null) {
                // Leaf node
                result.add(String.join("->", new ArrayList<>(stack).stream().map(node -> String.valueOf(node.val)).toArray(String[]::new)));
                stack.pop();
                visited.add(peek);
            } else if (peek.left != null && !visited.contains(peek.left)) {
                stack.push(peek.left);
            } else if (peek.right != null && !visited.contains(peek.right)) {
                stack.push(peek.right);
            } else {
                // Processed node
                stack.pop();
                visited.add(peek);
            }
        }

        return result;
    }


    /**
     * Time:    67.46% ->   O(n), where n is the number of nodes in the tree. We visit each node exactly once.
     * Space:   52.34% ->   O(h), where h is the height of the tree. This is the space used by the recursion stack.
     */
    public List<String> binaryTreePathsRec(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);

        binaryTreePathsRec(root, result, path);

        return result;
    }

    private void binaryTreePathsRec(TreeNode node, List<String> result, List<Integer> path) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            result.add(String.join("->", path.stream().map(String::valueOf).toArray(String[]::new)));
        }

        if (node.left != null) {
            path.add(node.left.val);
            binaryTreePathsRec(node.left, result, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            path.add(node.right.val);
            binaryTreePathsRec(node.right, result, path);
            path.remove(path.size() - 1);
        }
    }

}
