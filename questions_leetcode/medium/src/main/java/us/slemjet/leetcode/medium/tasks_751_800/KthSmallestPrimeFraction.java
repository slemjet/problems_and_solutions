package us.slemjet.leetcode.medium.tasks_751_800;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 786. K-th Smallest Prime Fraction
 */
public class KthSmallestPrimeFraction {

    /**
     * Time: O(n^2) ->  37.55%
     * Space:O(n^2) ->  65.50%
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int[] result = new int[2];

        Queue<int[]> priority = new PriorityQueue<>(Comparator.comparing((int[] ints) -> (double) arr[ints[0]] / (double) arr[ints[1]]));

        for (int i = 0; i < arr.length - 1; i++) {
            priority.add(new int[]{i, arr.length - 1}); // Populate with min val for each index
        }

        while (k > 1) {
            int[] polled = priority.poll();

            int top = polled[0];
            int bottom = polled[1];

            if (top < bottom - 1) {
                // Push next smallest value
                priority.offer(new int[]{top, bottom - 1});
            }
            k--;
        }

        int[] polled = priority.poll();
        result[0] = arr[polled[0]];
        result[1] = arr[polled[1]];

        return result;
    }
}
