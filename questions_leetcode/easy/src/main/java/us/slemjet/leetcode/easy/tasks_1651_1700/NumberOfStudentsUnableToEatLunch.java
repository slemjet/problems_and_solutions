package us.slemjet.leetcode.easy.tasks_1651_1700;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1700. Number of Students Unable to Eat Lunch
 */
public class NumberOfStudentsUnableToEatLunch {

    /**
     * Time: O(n + m)   ->  71.05%
     * Space:O(n + m)   ->  97.49%
     */
    public int countStudents(int[] students, int[] sandwiches) {

        int result = 0;
        Queue<Integer> waitList = new LinkedList<>();
        for (int student : students) {
            waitList.add(student);
        }

        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];
            int size = waitList.size();
            while (size >= 0) {
                int next = waitList.poll();
                if (next == sandwich) {
                    break;
                }
                waitList.add(next);
                size--;
            }
            if (size < 0) {
                return sandwiches.length - i;
            }
        }

        return result;
    }
}
