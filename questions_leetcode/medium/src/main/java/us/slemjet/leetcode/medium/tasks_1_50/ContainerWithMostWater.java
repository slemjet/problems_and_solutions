package us.slemjet.leetcode.medium.tasks_1_50;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int flat = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int currentFlat = Math.min(height[left], height[right]) * (right - left);
            flat = Math.max(flat, currentFlat);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return flat;
    }

    public int maxArea2(int[] height) {
        int flat = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currentFlat = Math.min(height[i], height[j]) * (j - i);
                flat = Math.max(flat, currentFlat);
            }
        }
        return flat;
    }
}
