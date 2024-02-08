package us.slemjet.leetcode.easy.tasks_251_300;

public class FirstBadVersion {

    /**
     * Runtime: 99.34%
     * Memory: 28.17%
     */
    public int firstBadVersion(int n) {

        int end = n;
        int start = 1;

        while (end > start) {

            int median = start + (end - start) / 2;
            if (isBadVersion(median)) {
                // need to decrease until start bad version is found
                end = median - 1;
            } else {
                // good version found - need to increase until bad version is found
                start = median + 1;
            }
        }

        return start;
    }

    /**
     * Recursion version
     * Runtime: 21.33%
     * Memory 5.03%
     */
    public int firstBadVersionRec(int n) {
        return firstBadVersionRec(1, n);
    }

    int firstBadVersionRec(int start, int end) {
        if (start > end) {
            return start;
        }
        int median = start + (end - start) / 2;
        if (isBadVersion(median)) {
            return firstBadVersionRec(start, median - 1);
        } else {
            return firstBadVersionRec(median + 1, end);
        }
    }

    boolean isBadVersion(int version) {
        return false;
    }

}
