package us.slemjet.leetcode.medium.tasks_751_800;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels
 */
public class PartitionLabels {

    /**
     * Runtime: 71.86%
     * Memory Usage: 49.62%
     */
    public List<Integer> partitionLabels(String s) {

        List<Integer> partitions = new ArrayList<>();

        // Contains last indices of each char
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            lastIndex[currChar - 'a'] = i;
        }

        int currIdx = 0;
        int leftIdx = 0;
        int rightIdx = 0;

        while (currIdx < s.length()) {
            char currChar = s.charAt(currIdx);

            int lastIndexOfChar = lastIndex[currChar - 'a'];
            // Extend current right index
            rightIdx = Math.max(rightIdx, lastIndexOfChar);

            // Check if partition is complete
            if (currIdx == rightIdx) {
                partitions.add(rightIdx - leftIdx + 1);
                leftIdx = currIdx + 1;
            }

            currIdx++;
        }

        return partitions;
    }
}
