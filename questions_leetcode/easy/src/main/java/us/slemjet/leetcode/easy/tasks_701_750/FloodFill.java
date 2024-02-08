package us.slemjet.leetcode.easy.tasks_701_750;

/**
 * 733. Flood Fill
 */
public class FloodFill {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 39.9 MB, less than 98.02%
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) return image;

        floodFill(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int targetColor, int newColor) {

        image[sr][sc] = newColor;

        if (sr + 1 < image.length && image[sr + 1][sc] == targetColor) {
            floodFill(image, sr + 1, sc, targetColor, newColor);
        }
        if (sr - 1 >= 0 && image[sr - 1][sc] == targetColor) {
            floodFill(image, sr - 1, sc, targetColor, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == targetColor) {
            floodFill(image, sr, sc + 1, targetColor, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == targetColor) {
            floodFill(image, sr, sc - 1, targetColor, newColor);
        }
    }
}
