package us.slemjet.leetcode.easy.from_701_to_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_701_to_750.FloodFill;

import java.util.stream.Stream;

class FloodFillTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 1, 0},
                                new int[]{1, 0, 1}}, 1, 1, 2, new int[][]{
                                new int[]{2, 2, 2},
                                new int[]{2, 2, 0},
                                new int[]{2, 0, 1}}
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 0}}, 1, 1, 2, new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 2, 0}}
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 1}}, 1, 1, 1, new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 1, 1}}
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 1, 0},
                                new int[]{1, 0, 1}}, 1, 1, 2, new int[][]{
                                new int[]{2, 2, 2},
                                new int[]{2, 2, 0},
                                new int[]{2, 0, 1}}

                )
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void checkInclusion(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        // given
        FloodFill solution = new FloodFill();

        // when
        int[][] result = solution.floodFill(image, sr, sc, newColor);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
