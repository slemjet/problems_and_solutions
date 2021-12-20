package us.slemjet.leetcode.hard.from_251_to_300;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 *
 */
public class FindMedianFromDataStream {

    /**
     * 2 Heaps
     *
     * Runtime: 41.64%
     * Memory Usage: 29.00%
     */
    public static class MedianFinder {

        PriorityQueue<Integer> smaller;
        PriorityQueue<Integer> larger;

        public MedianFinder() {
            smaller = new PriorityQueue<>();
            larger = new PriorityQueue<>(Comparator.reverseOrder()); // Reversed so latest is min
        }

        public void addNum(int num) {
            smaller.offer(num);
            larger.offer(smaller.poll());
            if (larger.size() > smaller.size()) {
                smaller.offer(larger.poll()); // Rebalance
            }
        }

        public double findMedian() {
            if (larger.size() == smaller.size()) {
                return ((double)larger.peek() + (double)smaller.peek()) / 2;
            } else {
                return (double)smaller.peek();
            }
        }
    }

}
