package us.slemjet.leetcode.medium.tasks_1351_1400;

/**
 * 1361. Validate Binary Tree Nodes
 */
public class ValidateBinaryTreeNodes {

    /**
     * Complexity:
     * Space: O(n)
     * Time:  O(n)
     *
     * Step 1: Calculate indegrees
     *
     * Step 2: Check conditions
     *
     * No node has an indegree greater than 1.
     * All nodes except node 3 have an indegree of 1.
     * There is one root (node 0).
     *
     * Step 3: Check node reachability using DFS.
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            int right = rightChild[i];

            if (left != -1) {
                inDegree[left]++;
                if (inDegree[left] > 1) {
                    return false; // Left child has more than one parent.
                }
            }

            if (right != -1) {
                inDegree[right]++;
                if (inDegree[right] > 1) {
                    return false; // Right child has more than one parent.
                }
            }
        }

        int rootCount = 0;
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                rootCount++;
                root = i;
                if (rootCount > 1) {
                    return false; // More than one root.
                }
            } else if (inDegree[i] != 1) {
                return false; // Node with indegree not equal to 1.
            }
        }

        if (rootCount != 1) {
            return false; // There should be exactly one root.
        }

        // Check if all nodes are reachable from the root.
        boolean[] visited = new boolean[n];
        dfs(root, leftChild, rightChild, visited);

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false; // Some nodes are not reachable from the root.
            }
        }

        return true;
    }

    private void dfs(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (node != -1) {
            visited[node] = true;
            dfs(leftChild[node], leftChild, rightChild, visited);
            dfs(rightChild[node], leftChild, rightChild, visited);
        }
    }

}
