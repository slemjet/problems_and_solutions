package us.slemjet.leetcode.easy.tasks_651_700;

/**
 * 661. Image Smoother
 */
public class ImageSmoother {

    /**
     * Time: O(n*m*l) -> 99.17%
     * Space: O(n*m) -> 22.78%
     */
    public int[][] imageSmoother(int[][] img) {

        int rows = img.length;
        int cols = img[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = calculate(img, i, j, rows, cols);
            }
        }

        return result;
    }

    private int calculate(int[][] img, int i, int j, int rows, int cols) {

        // Calculate boundaries
        int top = Math.max(0, i - 1);
        int bottom = Math.min(rows - 1, i + 1);
        int left = Math.max(0, j - 1);
        int right = Math.min(cols - 1, j + 1);

        int sum = 0;
        int count = 0;

        for (int k = top; k <= bottom; k++) {
            for (int l = left; l <= right; l++) {
                sum += img[k][l];
                count++;
            }
        }

        return sum / count;
    }
}
