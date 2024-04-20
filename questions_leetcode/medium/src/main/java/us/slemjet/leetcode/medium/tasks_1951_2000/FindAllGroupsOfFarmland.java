package us.slemjet.leetcode.medium.tasks_1951_2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1992. Find All Groups of Farmland
 */
public class FindAllGroupsOfFarmland {

    /**
     * Time: O(n * m)   ->  100.00%
     * Space:O(n * m)   ->  82.13%
     */
    public int[][] findFarmland(int[][] land) {

        List<int[]> fields = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {

                if (land[i][j] == 1) {
                    int[] field = traverseField(land, i, j);
                    fields.add(field);
                }
            }
        }
        return fields.toArray(new int[0][0]);
    }

    private int[] traverseField(int[][] land, int i, int j) {
        int maxI = i;
        for (int n = i; n < land.length && land[n][j] == 1; n++) {
            maxI = n;
        }

        int maxJ = j;
        for (int n = j; n < land[i].length && land[i][n] == 1; n++) {
            maxJ = n;
        }

        for (int dI = i; dI <= maxI; dI++) {
            for (int dJ = j; dJ <= maxJ; dJ++) {
                land[dI][dJ] = 0;
            }
        }

        return new int[]{i, j, maxI, maxJ};
    }
}
