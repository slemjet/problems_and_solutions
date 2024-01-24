package us.slemjet.leetcode.medium.tasks_1451_1500;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 */
public class PseudoPalindromicPathsInABinaryTree {

    /**
     * Time: O(n)    ->  70.82%
     * Space:O(n)    ->  53.74%
     */
    public int pseudoPalindromicPaths(TreeNode root) {

        return pseudoPalindromicPaths(root, new int[10]);
    }

    private int pseudoPalindromicPaths(TreeNode root, int[] counts) {

        if (root == null) {
            return 0;
        }

        int count = 0;
        counts[root.val]++;

        if (root.left == null && root.right == null) {
            // Is leaf node - check if is palindrome
            if (isPalindrome(counts)) {
                count++;
            }
        } else {
            // Sum of each subpaths
            int leftCount = pseudoPalindromicPaths(root.left, counts);
            int rightCount = pseudoPalindromicPaths(root.right, counts);
            count += leftCount + rightCount;
        }

        counts[root.val]--; // Backtrack
        return count;
    }

    private boolean isPalindrome(int[] counts) {
        boolean hasOdd = false;

        for (int count : counts) {
            if (count % 2 == 1) {
                if (hasOdd) {
                    return false; // Only one odd is allowed for palindrome
                } else {
                    hasOdd = true;
                }
            }
        }

        return true;
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
}
