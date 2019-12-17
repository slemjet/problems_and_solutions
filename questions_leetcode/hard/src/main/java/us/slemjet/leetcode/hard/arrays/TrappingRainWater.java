package us.slemjet.leetcode.hard.arrays;

import java.util.Stack;

public class TrappingRainWater {

    /**
     * 2 pointers based solution
     * Runtime: 100.00%
     * Memory Usage: 92.47%
     * @param height
     * @return
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
     * Stack based solution
     * Runtime: 17.78%
     * Memory Usage: 92.47%
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
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
