package us.slemjet.leetcode.medium.tasks_1551_1600;

/**
 * 1578. Minimum Time to Make Rope Colorful
 */
public class MinimumTimeToMakeRopeColorful {

    /**
     * Time: O(n) -> 61.18%
     * Space: O(1) -> 15.68%
     */
    public int minCost(String colors, int[] neededTime) {

        int result = 0;
        int idx = 1;

        while (idx < colors.length()) {
            if (colors.charAt(idx - 1) == colors.charAt(idx)) {
                // If we have a match - add all matching chars  except for maximum
                result += neededTime[idx - 1];
                int max = neededTime[idx - 1];
                while (idx < colors.length() && colors.charAt(idx - 1) == colors.charAt(idx)) {
                    max = Math.max(max, neededTime[idx]);
                    result += neededTime[idx];
                    idx++;
                }
                result -= max;
            } else {
                idx++;
            }
        }

        return result;
    }

    /**
     * Time: -> 27.51%
     * Space: -> 15.68%
     */
    public int minCost2(String colors, int[] neededTime) {
        int max = neededTime[0];
        int result = neededTime[0];

        for (int i = 1; i < colors.length(); ++i) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                result -= max;
                max = 0;
            }
            result += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }

        return result - max;
    }
}
