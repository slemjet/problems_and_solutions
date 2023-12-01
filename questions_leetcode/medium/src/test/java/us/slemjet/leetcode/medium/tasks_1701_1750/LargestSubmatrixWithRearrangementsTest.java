package us.slemjet.leetcode.medium.tasks_1701_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestSubmatrixWithRearrangementsTest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{0, 0, 1},
                        new int[]{1, 1, 1},
                        new int[]{1, 0, 1}}, 4),
                Arguments.of(new int[][]{
                        new int[]{1,0,1,0,1}}, 3),
                Arguments.of(new int[][]{
                        new int[]{1,1,0},
                        new int[]{1,0,1}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] matrix, int expected) {
        // given
        LargestSubmatrixWithRearrangements solution = new LargestSubmatrixWithRearrangements();

        // when
        int result = solution.largestSubmatrix(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}