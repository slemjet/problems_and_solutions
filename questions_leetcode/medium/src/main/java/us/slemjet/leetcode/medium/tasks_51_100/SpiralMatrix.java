package us.slemjet.leetcode.medium.tasks_51_100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Runtime: 100.00%
     * Memory Usage: 6.43%
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        int startX = 0, endX = matrix[0].length - 1;
        int startY = 0, endY = matrix.length - 1;

        while (startX <= endX && startY <= endY) {

            // Handle "single line" case
            if (startX == endX) {
                for (int i = startY; i <= endY; i++) result.add(matrix[i][endX]);
                return result;
            } else if (startY == endY) {
                for (int i = startX; i <= endX; i++) result.add(matrix[startY][i]);
                return result;
            }

            // Top horizontal line
            if (startX <= endX) {
                for (int i = startX; i <= endX; i++) result.add(matrix[startY][i]);
                startY++;
            }

            // Right vertical line
            if (startY <= endY) {
                for (int i = startY; i <= endY; i++) result.add(matrix[i][endX]);
                endX--;
            }

            // Bottom horizontal line
            if (startX <= endX) {
                for (int i = endX; i >= startX; i--) result.add(matrix[endY][i]);
                endY--;
            }

            // Left vertical line
            if (startY <= endY) {
                for (int i = endY; i >= startY; i--) result.add(matrix[i][startX]);
                startX++;
            }

        }

        return result;
    }

    /**
     * Runtime: 100.00%
     * Memory Usage: 24.43%
     */
    public List<Integer> spiralOrder2(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }

        return result;
    }
}
