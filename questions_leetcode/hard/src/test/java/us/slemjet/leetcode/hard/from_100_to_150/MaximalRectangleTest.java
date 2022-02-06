package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximalRectangleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new char[][]{
                        new char[]{'1', '0', '1', '0', '0'},
                        new char[]{'1', '0', '1', '1', '1'},
                        new char[]{'1', '1', '1', '1', '1'},
                        new char[]{'1', '0', '0', '1', '0'}}, 6),
                Arguments.of(new char[][]{
                        new char[]{'0', '0', '0', '1', '0', '0', '0'},
                        new char[]{'0', '0', '1', '1', '1', '0', '0'},
                        new char[]{'0', '1', '1', '1', '1', '1', '0'}}, 6),
                Arguments.of(new char[][]{new char[]{'0'}}, 0),
                Arguments.of(new char[][]{new char[]{'1'}}, 1));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalRectangleRowArea(char[][] matrix, int expected) {
        // given
        MaximalRectangle solution = new MaximalRectangle();

        // when
        int result = solution.maximalRectangleRowArea(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalRectangleDp(char[][] matrix, int expected) {
        // given
        MaximalRectangle solution = new MaximalRectangle();

        // when
        int result = solution.maximalRectangleDp(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalRectangleDp2(char[][] matrix, int expected) {
        // given
        MaximalRectangle solution = new MaximalRectangle();

        // when
        int result = solution.maximalRectangleDp2(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximalRectangle(char[][] matrix, int expected) {
        // given
        MaximalRectangle solution = new MaximalRectangle();

        // when
        int result = solution.maximalRectangleBrute(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}