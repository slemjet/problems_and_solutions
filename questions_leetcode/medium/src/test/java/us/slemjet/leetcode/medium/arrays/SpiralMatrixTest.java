package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SpiralMatrixTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9}},
                        Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of(new int[][]{
                                new int[]{1, 2, 3, 4},
                                new int[]{5, 6, 7, 8},
                                new int[]{9, 10, 11, 12}},
                        Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
                Arguments.of(new int[][]{
                                new int[]{1}},
                        Collections.singletonList(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        // given
        SpiralMatrix solution = new SpiralMatrix();

        // when
        List<Integer> result = solution.spiralOrder(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void spiralOrder2(int[][] matrix, List<Integer> expected) {
        // given
        SpiralMatrix solution = new SpiralMatrix();

        // when
        List<Integer> result = solution.spiralOrder2(matrix);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
