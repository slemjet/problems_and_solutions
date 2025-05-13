package us.slemjet.hackerrank.questions;

import java.util.List;

/**
 * Grading Students
 */
public class GradingStudents {

    /**
     *
     */
    public List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < 38)
                continue;

            if (grades.get(i) % 5 > 2)
                grades.set(i, grades.get(i) + 5 - grades.get(i) % 5);
        }

        return grades;
    }
}
