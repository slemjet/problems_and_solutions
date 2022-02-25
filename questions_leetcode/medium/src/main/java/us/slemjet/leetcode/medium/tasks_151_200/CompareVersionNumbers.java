package us.slemjet.leetcode.medium.tasks_151_200;

/**
 * 165. Compare Version Numbers
 */
public class CompareVersionNumbers {

    /**
     * Runtime: 90.92%
     * Memory Usage: 46.64%
     */
    public int compareVersion(String version1, String version2) {

        int result = 0;

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);
        for (int i = 0; i < length; i++) {
            int value1 = 0;
            int value2 = 0;

            if (i < v1.length) value1 = Integer.parseInt(v1[i]);
            if (i < v2.length) value2 = Integer.parseInt(v2[i]);

            int compare = Integer.compare(value1, value2);
            if (compare != 0) return compare;
        }

        return result;
    }
}
