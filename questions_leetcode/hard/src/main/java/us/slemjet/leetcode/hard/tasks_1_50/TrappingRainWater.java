package us.slemjet.leetcode.hard.tasks_1_50;

import java.util.Stack;

/**
 * 42. Trapping Rain Water
 */
public class TrappingRainWater {

    /**
     * 2 pointers based solution
     * Runtime: 100.00%
     * Memory Usage: 92.47%
     */
    public int trap(int[] height) {
        int result = 0;

        int leftIdx = 0;
        int rightIdx = height.length - 1;

        // trim from both sides until stops ascending
        while (leftIdx < rightIdx && height[leftIdx] <= height[leftIdx + 1])
            leftIdx++;

        while (leftIdx < rightIdx && height[rightIdx] <= height[rightIdx - 1])
            rightIdx--;

        while (leftIdx < rightIdx) {
            int leftVal = height[leftIdx];
            int rightVal = height[rightIdx];

            if (leftVal <= rightVal) { // go from the left side
                while (leftIdx < rightIdx && leftVal >= height[leftIdx]) { // keep adding while values decrease
                    int space = leftVal - height[leftIdx];
                    result += space;
                    leftIdx++;
                }
            } else { // go from the right (smaller side)
                while (leftIdx < rightIdx && rightVal >= height[rightIdx]) { // keep adding while values decrease
                    int space = rightVal - height[rightIdx];
                    result += space;
                    rightIdx--;
                }
            }
        }
        return result;
    }

    /**
     * DP Bottom Up
     * Store max to the left and to the right of i
     * water = height[i]  - min(leftMax, rightMax)
     *
     * Runtime: 91.61%
     * Memory Usage: 49.97%
     */
    public int trapDpBottomUp(int[] height) {
        int result = 0;
        int length = height.length;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[length - i - 1] = Math.max(height[length - i - 1], rightMax[length - i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return result;
    }

    /**
     * Stack based solution
     * Runtime: 17.78%
     * Memory Usage: 92.47%
     */
    public int trapStack(int[] height) {
        int result = 0;
        if (height.length < 1) return result;

        Stack<Integer> drops = new Stack<>();
        int i = 0;
        while (i < height.length) {
            if (drops.isEmpty() || height[drops.peek()] >= height[i])
                drops.push(i++); // drop found - adding
            else {
                int prevDrop = drops.pop(); // we need to consider local maximum
                if (!drops.isEmpty()) {
                    // get the lower of two borders
                    int minHeight = Math.min(height[drops.peek()], height[i]);
                    int space = (minHeight - height[prevDrop]) * (i - drops.peek() - 1);
                    result += space;
                }
            }
        }
        return result;
    }
}
