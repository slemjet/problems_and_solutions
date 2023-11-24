package us.slemjet.leetcode.medium.tasks_1401_1450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DiagonalTraverseIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of(1, 2, 3),
                        List.of(4, 5, 6),
                        List.of(7, 8, 9)), new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9}),
                Arguments.of(List.of(
                        List.of(1, 2, 3, 4, 5),
                        List.of(6, 7),
                        List.of(8),
                        List.of(9, 10, 11),
                        List.of(12, 13, 14, 15, 16)), new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16}),
                Arguments.of(List.of(
                        List.of(1, 2, 3, 4, 5, 6)), new int[]{1, 2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(List<List<Integer>> nums, int[] expected) {
        // given
        DiagonalTraverseII solution = new DiagonalTraverseII();

        // when
        int[] result = solution.findDiagonalOrder(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution2Loops(List<List<Integer>> nums, int[] expected) {
        // given
        DiagonalTraverseII solution = new DiagonalTraverseII();

        // when
        int[] result = solution.findDiagonalOrder2Loops(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionMap(List<List<Integer>> nums, int[] expected) {
        // given
        DiagonalTraverseII solution = new DiagonalTraverseII();

        // when
        int[] result = solution.findDiagonalOrderMap(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}