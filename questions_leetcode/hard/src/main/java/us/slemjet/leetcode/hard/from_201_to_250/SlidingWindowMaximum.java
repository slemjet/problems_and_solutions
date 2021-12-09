package us.slemjet.leetcode.hard.from_201_to_250;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {

    /**
     * Runtime: 54.18%
     * Memory Usage: 49.45%
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> window = new ArrayDeque<>(); // Monotonous queue

        for (int i = 0; i < nums.length; i++) {
            int next = nums[i];
            if (!window.isEmpty()) {
                if (i >= k && window.peekLast() == nums[i - k]) {
                    window.pollLast(); // Window shift to the right removes current max
                }
                while (!window.isEmpty()) {
                    if (window.peekFirst() < next)
                        window.pollFirst(); // Populate monotonic queue - remove lesser element
                    else break;
                }
            }
            window.push(next);

            if (i >= k - 1) {
                result[idx++] = window.peekLast();
            }
        }

        return result;
    }
}
