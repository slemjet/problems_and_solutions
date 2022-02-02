package us.slemjet.leetcode.easy.from_1401_to_1450;

/**
 * 1450. Number of Students Doing Homework at a Given Time
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {

    /**
     * Runtime: 20.54%
     * Memory Usage: 5.09%
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int result = 0;

        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i] >= queryTime && startTime[i] <= queryTime) result++;
        }

        return result;
    }

}
