package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 */
public class MinimumDominoRotationsForEqualRow {

    /**
     * Runtime: 79.16%
     * Memory Usage: 23.33%
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length) return -1;

        int[] countTops = new int[7]; // Number of domino values for top
        int[] countBottoms = new int[7]; // Number of domino values for bottom
        int[] countSame = new int[7]; // Number of domino values having same

        for (int i = 0; i < tops.length; i++) {
            countTops[tops[i]]++;
            countBottoms[bottoms[i]]++;
            if (tops[i] == bottoms[i])
                countSame[tops[i]]++;
        }

        for (int i = 0; i < 7; i++) {
            if (countTops[i] + countBottoms[i] - countSame[i] == tops.length) // Can form row
                // Lesser of bottom rotations or top rotation (more optimal) - same (no rotation)
                return Math.min(countTops[i], countBottoms[i]) - countSame[i];
        }
        return -1;
    }

    /**
     * Runtime: 33.75%
     * Memory Usage: 20.17%
     */
    public int minDominoRotations2(int[] tops, int[] bottoms) {

        int[] topCount = new int[2];
        int[] bottomCount = new int[2];

        topCount[0] = tops.length - 1;
        topCount[1] = topCount[0] + 1;
        bottomCount[1] = bottoms.length - 1;
        bottomCount[0] = bottomCount[1] + 1;

        for (int i = 1; i < tops.length; i++) {
            if (topCount[0] != -1 && topCount[1] != -1) {
                if (tops[0] != tops[i] && tops[0] != bottoms[i]) {
                    topCount[0] = -1;
                    topCount[1] = -1;
                } else {
                    if (tops[0] == tops[i]) topCount[0]--;
                    if (tops[0] == bottoms[i]) topCount[1]--;
                }
            }

            if (bottomCount[0] != -1 && bottomCount[1] != -1) {
                if (bottoms[0] != bottoms[i] && bottoms[0] != tops[i]) {
                    bottomCount[0] = -1;
                    bottomCount[1] = -1;
                } else {
                    if (bottoms[0] == bottoms[i]) bottomCount[1]--;
                    if (bottoms[0] == tops[i]) bottomCount[0]--;
                }
            }
        }


        int result = Integer.MAX_VALUE;
        if (topCount[0] != -1) result = Math.min(result, topCount[0]);
        if (topCount[1] != -1) result = Math.min(result, topCount[1]);
        if (bottomCount[0] != -1) result = Math.min(result, bottomCount[0]);
        if (bottomCount[1] != -1) result = Math.min(result, bottomCount[1]);

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
