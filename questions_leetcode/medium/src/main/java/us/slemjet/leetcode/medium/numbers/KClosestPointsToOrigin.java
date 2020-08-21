package us.slemjet.leetcode.medium.numbers;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    /**
     * Runtime: 19 ms, faster than 76.57%
     * Memory Usage: 47.9 MB, less than 80.37%
     */
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> elements = new PriorityQueue<>(K, (o1, o2) -> Integer.compare((o2[0] * o2[0]) + (o2[1] * o2[1]), (o1[0] * o1[0]) + (o1[1] * o1[1])));
        for (int[] point : points) {
            elements.add(point);
            if (elements.size() > K)
                elements.poll();
        }
        return elements.toArray(new int[0][]);
    }
}
