package us.slemjet.leetcode.hard.from_251_to_300;

import java.util.*;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * Use DFS
     * Runtime: 53.17%
     * Memory Usage: 73.61%
     */
    public static class CodecDfs {
        TreeNode nullStub = new TreeNode(0);

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            Stack<TreeNode> nodes = new Stack<>();
            nodes.push(root);

            StringBuilder result = new StringBuilder();

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if (node != null) {
                    result.append(node.val).append(",");
                    nodes.push(node.right);
                    nodes.push(node.left);
                } else {
                    result.append("null,");
                }
            }
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            TreeNode root = null;
            Stack<TreeNode> nodeStack = new Stack<>();

            for (String value : data.split(",")) {
                TreeNode treeNode = value.equals("null") ? nullStub : new TreeNode(Integer.parseInt(value));
                if (root == null && treeNode != nullStub) root = treeNode;
                if (nodeStack.isEmpty() && treeNode != nullStub) nodeStack.push(treeNode);
                else {
                    while (!nodeStack.isEmpty()) {
                        TreeNode parentNode = nodeStack.peek();
                        if (parentNode.left == null) {
                            parentNode.left = treeNode;
                            if (treeNode != nullStub) nodeStack.push(treeNode);
                            break;
                        } else if (parentNode.right == null) {
                            parentNode.right = treeNode;
                            if (treeNode != nullStub) nodeStack.push(treeNode);
                            break;
                        } else {
                            parentNode.left = parentNode.left == nullStub ? null : parentNode.left;
                            parentNode.right = parentNode.right == nullStub ? null : parentNode.right;
                            nodeStack.pop();
                        }
                    }
                }
            }

            // Clear stack
            while (!nodeStack.isEmpty()) {
                TreeNode treeNode = nodeStack.pop();
                treeNode.left = treeNode.left == nullStub ? null : treeNode.left;
                treeNode.right = treeNode.right == nullStub ? null : treeNode.right;
            }

            return root;
        }
    }

    /**
     * Use BFS
     * Runtime: 53.17% of Java online submissions for Serialize and Deserialize Binary Tree.
     * Memory Usage: 78.19% of Java online submissions for Serialize and Deserialize Binary
     */
    public static class CodecBfs {
        TreeNode nullStub = new TreeNode(0);

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root == null ? nullStub : root);

            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                result.append(treeNode == null || treeNode == nullStub ? "null" : treeNode.val).append(",");
                if (treeNode != null && treeNode != nullStub) {
                    queue.add(treeNode.left == null ? nullStub : treeNode.left);
                    queue.add(treeNode.right == null ? nullStub : treeNode.right);
                }
            }
            result.deleteCharAt(result.length() - 1);
            return result.toString();
        }

        public TreeNode deserialize(String data) {

            TreeNode root = null;
            Deque<TreeNode> current = new ArrayDeque<>();
            int idx = 0;
            int nextIdx = idx;

            String[] values = data.split(",");
            // Set initial value
            if (!values[idx].equals("null")) {
                current.offer(new TreeNode(Integer.parseInt(values[idx])));
                idx++;
                nextIdx = idx + 2; // 2 more subNodes nodes expected
                root = current.peek();
            }

            while (!current.isEmpty()) {

                Deque<TreeNode> tmp = new ArrayDeque<>();
                while (idx < nextIdx) {
                    // Populate next queue
                    String value = values[idx];
                    TreeNode nextNode = value.equals("null") ? nullStub : new TreeNode(Integer.parseInt(value));
                    tmp.offer(nextNode);
                    idx++;
                }

                Deque<TreeNode> next = new ArrayDeque<>();
                // Link nodes to parent node
                while (!current.isEmpty()) {
                    TreeNode curr = current.pollFirst();
                    TreeNode leftNext = tmp.pollFirst();
                    if (leftNext != nullStub) {
                        curr.left = leftNext;
                        next.offerLast(leftNext);
                        nextIdx += 2;
                    }
                    TreeNode rightNext = tmp.pollFirst();
                    if (rightNext != nullStub) {
                        curr.right = rightNext;
                        next.offerLast(rightNext);
                        nextIdx += 2;
                    }

                }
                current = next;
            }

            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
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
