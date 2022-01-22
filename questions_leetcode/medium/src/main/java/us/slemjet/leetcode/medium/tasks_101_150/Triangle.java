package us.slemjet.leetcode.medium.tasks_101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 */
public class Triangle {

    /**
     * DB Bottom Up - use only current level for space optimization
     * Runtime: 61.99%
     * Memory Usage: 65.92%
     */
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {

        List<Integer> currLevel = new ArrayList<>(triangle.get(triangle.size() - 1));
        int value;

        while (currLevel.size() > 1) { // On each level size is decreased by 1 - last level has size 1
            for (int i = 0; i < currLevel.size() - 1; i++) {
                value = triangle.get(currLevel.size() - 2).get(i); // Current value to be added
                currLevel.set(i, value + Math.min(currLevel.get(i), currLevel.get(i + 1))); // Min of below and to the right
            }
            currLevel.remove(currLevel.size() - 1);
        }

        return currLevel.get(0);
    }

    /**
     * DB Bottom Up
     *
     * Runtime: 30.91%
     * Memory Usage: 29.51%
     */
    public int minimumTotalBottomUp2(List<List<Integer>> triangle) {

        for (int j = triangle.size() - 2; j >= 0; j--) {
            for (int i = 0; i < triangle.get(j).size(); i++) {
                triangle.get(j).set(i,
                        triangle.get(j).get(i) + Math.min(triangle.get(j + 1).get(i), triangle.get(j + 1).get(i + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * Top to Bottom - space optimized - no input modification, use only current row list
     * <p>
     * Runtime: 21.28%
     * Memory Usage: 34.75%
     */
    public int minimumTotalTopToBottom(List<List<Integer>> triangle) {

        if (triangle.size() == 1) return triangle.get(0).get(0);

        int result = Integer.MAX_VALUE, next = Integer.MAX_VALUE;
        List<Integer> currentRow = new ArrayList<>(triangle.get(0));

        while (currentRow.size() < triangle.size()) {
            List<Integer> currInputRow = triangle.get(currentRow.size());
            next = currentRow.get(currentRow.size() - 1) + currInputRow.get(currInputRow.size() - 1);
            for (int i = currentRow.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    currentRow.set(i, currInputRow.get(i) + currentRow.get(i));
                } else {
                    currentRow.set(i, currInputRow.get(i) + Math.min(currentRow.get(i), currentRow.get(i - 1)));
                }
                if (currentRow.size() == triangle.size() - 1) { // Last row
                    result = Math.min(result, currentRow.get(i));
                }
            }
            currentRow.add(next);
        }

        return Math.min(result, next);
    }
}
