package us.slemjet.leetcode.medium.trees;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CourseScheduleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
//                Arguments.of(2, new int[][]{}, true), // []
//                Arguments.of(2, new int[][]{{1, 0}}, true), // [1:0]
//                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false), // [[1:0],[0:1]]
//                Arguments.of(3, new int[][]{{0, 2}, {1, 2}, {2, 0}}, false), // 3 [[0,2],[1,2],[2,0]]
                Arguments.of(9, new int[][]{{0, 1}, {1, 3}, {1, 4}, {2, 4}, {4, 6}, {5, 7}, {7, 8}}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionKahn(int numCourses, int[][] prerequisites, boolean expected) {
        // given
        CourseSchedule solution = new CourseSchedule();

        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                System.out.printf("[%d;%d]=%d ", i, j, prerequisites[i][j]);
            }
            System.out.println();
        }

        // when
        boolean value = solution.canFinishKahn(numCourses, prerequisites);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDFS(int numCourses, int[][] prerequisites, boolean expected) {
        // given
        CourseSchedule solution = new CourseSchedule();

        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                System.out.printf("[%d;%d]=%d ", i, j, prerequisites[i][j]);
            }
            System.out.println();
        }

        // when
        boolean value = solution.canFinishDFS(numCourses, prerequisites);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

}
