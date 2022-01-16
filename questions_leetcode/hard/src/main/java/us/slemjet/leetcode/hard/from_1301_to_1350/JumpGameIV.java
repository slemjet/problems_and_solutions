package us.slemjet.leetcode.hard.from_1301_to_1350;

import java.util.*;

/**
 * 1345. Jump Game IV
 */
public class JumpGameIV {

    /**
     * Use BFS approach.
     * Index is a node, edge - is to which node we can get from this node
     *
     * Runtime: 59.73%
     * Memory Usage: 33.60%
     */
    public int minJumps(int[] arr) {

        int result = 0;
        if(arr.length == 1) return 0;

        Map<Integer, List<Integer>> jumps = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            jumps.computeIfAbsent(arr[i], integer -> new ArrayList<>()).add(i);
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(0); // Initialize with first element

        while (!nodes.isEmpty()) {
            result++; // Increment level
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                Integer currNode = nodes.poll();

                // Add all possible candidates
                // Next node - check if is in bounds and can jump to it
                if (currNode < arr.length - 1 && jumps.containsKey(arr[currNode + 1])) {
                    if (currNode + 1 == arr.length - 1)
                        return result; // Next node is the answer
                    nodes.offer(currNode + 1);
                }
                // From jumps map
                if (jumps.containsKey(arr[currNode])) {
                    for (Integer nextNode : jumps.get(arr[currNode])) {
                        if (nextNode == arr.length - 1)
                            return result; // Next node is the answer
                        if (!nextNode.equals(currNode)) {
                            nodes.offer(nextNode);
                        }
                    }
                    jumps.remove(arr[currNode]); // !Important - remove current node to exclude duplicate jumps
                }

                // Previous node - check if is in bounds and can jump to it
                if (currNode > 0 && jumps.containsKey(arr[currNode - 1])) {
                    nodes.offer(currNode - 1);
                }
            }
        }

        return result;
    }
}
