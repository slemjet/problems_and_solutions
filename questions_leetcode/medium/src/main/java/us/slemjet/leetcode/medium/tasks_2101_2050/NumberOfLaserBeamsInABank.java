package us.slemjet.leetcode.medium.tasks_2101_2050;

/**
 * 2125. Number of Laser Beams in a Bank
 */
public class NumberOfLaserBeamsInABank {

    /**
     * Time: O(n)   ->  16.07%
     * Space: O(1)  ->  5.36%
     */
    public int numberOfBeams(String[] bank) {

        int count = 0;
        int prevCount = 0;

        for (String row : bank) {

            int currCount = 0;
            for (char aChar : row.toCharArray()) {
                if (aChar == '1') {
                    currCount++;
                }
            }

            if (currCount > 0) {
                count += currCount * prevCount;
                prevCount = currCount;
            }
        }
        return count;
    }
}
