package us.slemjet.leetcode.hard.from_50_to_100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 84. Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {

    /**
     * Dynamic range jump
     * Runtime: 98.59%
     * Memory Usage: 84.86%
     */
    public int largestRectangleAreaDynamic(int[] heights) {

        int max = 0;

        int[] leftBorderIdx = new int[heights.length];
        int[] rightBorderIdx = new int[heights.length];
        leftBorderIdx[0] = -1;
        rightBorderIdx[heights.length - 1] = heights.length;

        // Populate left borders - where rectangle with current height begins
        for (int i = 1; i < heights.length; i++) {

            int minLeftIdx = i - 1; // start from adjusted left element
            while (minLeftIdx >= 0 && heights[i] <= heights[minLeftIdx]) { // Skip if element is not lower
                minLeftIdx = leftBorderIdx[minLeftIdx]; // If element includes current element (is >= jump to its edge)
            }
            leftBorderIdx[i] = minLeftIdx;

        }

        // Populate right borders - where rectangle with current height ends
        for (int i = heights.length - 2; i >= 0; i--) {

            int minRightIdx = i + 1; // start from adjusted right element
            while (minRightIdx < heights.length && heights[i] <= heights[minRightIdx]) { // Skip if element is not lower
                minRightIdx = rightBorderIdx[minRightIdx]; // If element includes current element (is >= jump to its edge)
            }
            rightBorderIdx[i] = minRightIdx;

        }

        // Use border range and height to calculate square
        for (int i = 0; i < heights.length; i++) {
            int currMax = heights[i] * (rightBorderIdx[i] - leftBorderIdx[i] - 1);
            max = Math.max(max, currMax);
        }

        return max;
    }

    /**
     * Stack
     * Runtime: 51.33%
     * Memory Usage: 67.29%
     */
    public int largestRectangleAreaStack(int[] heights) {

        int max = 0;
        Stack<Integer> stackIdx = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];

            while (!stackIdx.isEmpty() && height < heights[stackIdx.peek()]) { // We need stack in ascending order
                int currHeight = heights[stackIdx.pop()];
                int prevIndex = stackIdx.isEmpty() ? -1 : stackIdx.peek();
                int area = currHeight * (i - prevIndex - 1);
                max = Math.max(max, area);
            }
            stackIdx.push(i);
        }

        return max;
    }

    /**
     * Naive
     * Runtime: 5.05%
     * Memory Usage: 29.50%
     */
    public int largestRectangleArea(int[] heights) {

        int currMax = 0;

        Map<Integer, Integer> currMap = new HashMap<>();

        for (int height : heights) {
            int newCount = 0;
            List<Integer> existingKeys = currMap.keySet().stream().sorted().collect(Collectors.toList());
            for (int existingKey : existingKeys) {
                if (existingKey <= height) {
                    // increment
                    currMap.put(existingKey, currMap.get(existingKey) + 1);
                } else {
                    // remove all bigger
                    Integer exitingCount = currMap.get(existingKey);
                    int square = existingKey * exitingCount;
                    currMax = Math.max(currMax, square);
                    currMap.remove(existingKey);
                    newCount = Math.max(exitingCount, newCount);
                }
            }

            if (!currMap.containsKey(height)) {
                currMap.put(height, newCount + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : currMap.entrySet()) {
            int square = entry.getKey() * entry.getValue();
            currMax = Math.max(currMax, square);
        }

        return currMax;
    }
}
