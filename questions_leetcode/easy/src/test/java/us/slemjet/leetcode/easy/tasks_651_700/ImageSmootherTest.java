package us.slemjet.leetcode.easy.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ImageSmootherTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 0, 1},
                                new int[]{1, 0, 1}},
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 0, 0},
                                new int[]{0, 0, 0}}),
                Arguments.of(
                        new int[][]{
                                new int[]{100, 200, 100},
                                new int[]{200, 50, 200},
                                new int[]{100, 200, 100}},
                        new int[][]{
                                new int[]{137, 141, 137},
                                new int[]{141, 138, 141},
                                new int[]{137, 141, 137}})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] img, int[][] expected) {
        // given
        ImageSmoother solution = new ImageSmoother();

        // when
        int[][] result = solution.imageSmoother(img);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}