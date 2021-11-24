package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CourseScheduleIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // 2 -> [[1,0]] -> [0,1]
                Arguments.of(2, new int[][]{new int[]{1, 0}}, new int[]{0, 1}),
                // 4 -> [[1,0],[2,0],[3,1],[3,2]] -> [0,2,1,3]
                Arguments.of(4, new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}}, new int[]{0, 1, 2, 3}),
                // 3 -> [[1,0],[1,2],[0,1]] -> [2,1,0]
                Arguments.of(3, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{0, 1}}, new int[0])
        );
    }

    private static Stream<Arguments> parameters2() {
        return Stream.of(
                // 2 -> [[1,0]] -> [0,1]
                Arguments.of(2, new int[][]{new int[]{1, 0}}, new int[]{0, 1}),
                // 4 -> [[1,0],[2,0],[3,1],[3,2]] -> [0,2,1,3]
                Arguments.of(4, new int[][]{new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 1}, new int[]{3, 2}}, new int[]{0, 2, 1, 3}),
                // 3 -> [[1,0],[1,2],[0,1]] -> [2,1,0]
                Arguments.of(3, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{0, 1}}, new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsFindOrder(int numCourses, int[][] prerequisites, int[] expected) {
        // given
        CourseScheduleII solution = new CourseScheduleII();

        // when
        int[] result = solution.findOrder(numCourses, prerequisites);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters2")
    void testsFindOrderBFS(int numCourses, int[][] prerequisites, int[] expected) {
        // given
        CourseScheduleII solution = new CourseScheduleII();

        // when
        int[] result = solution.findOrderBFS(numCourses, prerequisites);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}