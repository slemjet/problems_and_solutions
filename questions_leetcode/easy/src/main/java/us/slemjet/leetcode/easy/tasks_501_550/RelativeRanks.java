package us.slemjet.leetcode.easy.tasks_501_550;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 506. Relative Ranks
 */
public class RelativeRanks {

    /**
     * Time: O(nlogn)   ->  65.84%
     * Space:O(n)       ->  17.05%
     */
    public String[] findRelativeRanks(int[] score) {

        String[] result = new String[score.length];

        Queue<int[]> piorityQueue = new PriorityQueue<>(Comparator.comparingInt((int[] value) -> value[0]).reversed());

        for (int i = 0; i < score.length; i++) {
            piorityQueue.add(new int[]{score[i], i});
        }

        int rank = 1;
        while (!piorityQueue.isEmpty()) {
            int[] athlete = piorityQueue.poll();

            switch (rank) {
                case 1:
                    result[athlete[1]] = "Gold Medal";
                    break;
                case 2:
                    result[athlete[1]] = "Silver Medal";
                    break;
                case 3:
                    result[athlete[1]] = "Bronze Medal";
                    break;
                default:
                    result[athlete[1]] = rank + "";
            }

            rank++;
        }

        return result;
    }
}
