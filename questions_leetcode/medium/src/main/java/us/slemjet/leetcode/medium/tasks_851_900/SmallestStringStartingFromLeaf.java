package us.slemjet.leetcode.medium.tasks_851_900;

import us.slemjet.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 988. Smallest String Starting From Leaf
 */
public class SmallestStringStartingFromLeaf {

    /**
     * Time: O(n)   ->  54.93%
     * Space:O(n)   ->  63.52%
     */
    public String smallestFromLeaf(TreeNode root) {

        List<Integer> smallestPath = smallestFromLeaf(root, new ArrayList<>());
        StringBuilder result = new StringBuilder();
        for (Integer letter : smallestPath) {
            result.append((char)('a' + letter));
        }
        return result.toString();
    }

    private List<Integer> smallestFromLeaf(TreeNode root, List<Integer> path) {

        if (root == null) {
            return null;
        }

        path = new ArrayList<>(path);
        path.add(0, root.val);

        if (root.right == null && root.left == null) {
            return path;
        }

        List<Integer> leftSmallestPath = smallestFromLeaf(root.left, path);;
        List<Integer> rightSmallestPath = smallestFromLeaf(root.right, path);;

        return smallestPath(leftSmallestPath, rightSmallestPath);
    }

    private List<Integer> smallestPath(List<Integer> leftSmallestPath, List<Integer> rightSmallestPath) {

        if (leftSmallestPath == null) {
            return rightSmallestPath;
        }
        if (rightSmallestPath == null) {
            return leftSmallestPath;
        }

        int maxLength = Math.max(leftSmallestPath.size(), rightSmallestPath.size());

        for (int i = 0; i < maxLength; i++) {
            if (leftSmallestPath.size() == i) {
                return leftSmallestPath;
            }
            if (rightSmallestPath.size() == i) {
                return rightSmallestPath;
            }
            if (!Objects.equals(leftSmallestPath.get(i), rightSmallestPath.get(i))) {
                if (leftSmallestPath.get(i) < rightSmallestPath.get(i)) {
                    return leftSmallestPath;
                } else {
                    return rightSmallestPath;
                }
            }
        }

        return leftSmallestPath;
    }
}
