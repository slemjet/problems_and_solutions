package us.slemjet.leetcode.easy.from_601_to_650.tasks;

/**
 * 605. Can Place Flowers
 */
public class CanPlaceFlowers {

    /**
     * Optimized version - we jump 2 steps if 1 is found to reduce number of checks
     *
     * Runtime: 100.00%
     * Memory Usage: 87.65%
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int idx = 0;

        while (n > 0 && idx < flowerbed.length) {
            if (flowerbed[idx] == 0){
                if (idx == flowerbed.length - 1 || flowerbed[idx + 1] == 0) {
                    n--; // Plant new
                } else {
                    idx++; // Switch to next 1
                }
            }
            // Current is 1 (either initially or by planting new) -> next candidate is 2 tiles apart
            idx += 2;
        }

        return n == 0;
    }

    /**
     * Runtime: 31.85%
     * Memory Usage: 24.30%
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {

        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; // Add plant
                if (--n == 0) {
                    return true;
                }
            }
        }

        return n == 0;
    }


}