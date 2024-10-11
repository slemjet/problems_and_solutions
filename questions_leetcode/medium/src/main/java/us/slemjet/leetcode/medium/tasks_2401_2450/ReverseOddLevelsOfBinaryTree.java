package us.slemjet.leetcode.medium.tasks_2401_2450;

import us.slemjet.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2415. Reverse Odd Levels of Binary Tree
 */
public class ReverseOddLevelsOfBinaryTree {

    /**
     * Time: O(n)
     * Space:O(n)
     */
    public TreeNode reverseOddLevels(TreeNode root) {

        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> odd;
        List<TreeNode> even;
        current.add(root);

        while (!current.isEmpty()) {

            odd = new ArrayList<>();
            even = new ArrayList<>();

            int size = current.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = current.get(i);

                if (node.left != null) {
                    odd.add(node.left);
                    if (node.left.left != null)
                        even.add(node.left.left);
                    if (node.left.right != null)
                        even.add(node.left.right);
                }
                if (node.right != null) {
                    odd.add(node.right);
                    if (node.right.left != null)
                        even.add(node.right.left);
                    if (node.right.right != null)
                        even.add(node.right.right);
                }
            }

            Collections.reverse(odd);

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = current.get(i);

                if (odd.isEmpty()) continue;
                currentNode.left = odd.get(i * 2);
                currentNode.right = odd.get(i * 2 + 1);

                if (even.isEmpty()) continue;
                currentNode.left.left = even.get(i * 4);
                currentNode.left.right = even.get(i * 4 + 1);
                currentNode.right.left = even.get(i * 4 + 2);
                currentNode.right.right = even.get(i * 4 + 3);
            }

            current = even;

        }

        return root;
    }
}
