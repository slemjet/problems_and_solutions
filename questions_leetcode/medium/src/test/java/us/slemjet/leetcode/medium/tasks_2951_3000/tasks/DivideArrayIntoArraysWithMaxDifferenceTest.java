package us.slemjet.leetcode.medium.tasks_2951_3000.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DivideArrayIntoArraysWithMaxDifferenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2,
                        new int[][]{
                                new int[]{1, 1, 3},
                                new int[]{3, 4, 5},
                                new int[]{7, 8, 9}}),
                Arguments.of(new int[]{1, 3, 3, 2, 7, 3}, 3,
                        new int[][]{})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, int[][] expected) {
        // given
        DivideArrayIntoArraysWithMaxDifference solution = new DivideArrayIntoArraysWithMaxDifference();

        // when
        int[][] result = solution.divideArray(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}