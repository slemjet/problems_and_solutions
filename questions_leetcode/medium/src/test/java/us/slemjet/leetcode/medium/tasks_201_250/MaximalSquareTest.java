package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximalSquareTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'1', '0', '1', '0', '0'},
                        new char[]{'1', '0', '1', '1', '1'},
                        new char[]{'1', '1', '1', '1', '1'},
                        new char[]{'1', '0', '0', '1', '0'}}, 4),
                Arguments.of(new char[][]{
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '1', '1', '1'},
                        new char[]{'1', '1', '1', '1', '1'},
                        new char[]{'0', '0', '1', '1', '1'}}, 16),
                Arguments.of(new char[][]{
                        new char[]{'0', '1'},
                        new char[]{'1', '0'}}, 1),
                Arguments.of(new char[][]{
                        new char[]{'1', '1'},
                        new char[]{'1', '1'}}, 4),
                Arguments.of(new char[][]{
                        new char[]{'0'}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalSquare(char[][] matrix, int expected) {
        // given
        MaximalSquare solution = new MaximalSquare();

        // when
        int result = solution.maximalSquare2(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalSquare2(char[][] matrix, int expected) {
        // given
        MaximalSquare solution = new MaximalSquare();

        // when
        int result = solution.maximalSquare2(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}