package us.slemjet.leetcode.easy.tasks_1551_1600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SpecialPositionsInABinaryMatrixTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 0, 0},
                        new int[]{0, 0, 1},
                        new int[]{1, 0, 0}}, 1),
                Arguments.of(new int[][]{
                        new int[]{1, 0, 0},
                        new int[]{0, 1, 0},
                        new int[]{0, 0, 1}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] mat, int expected) {
        // given
        SpecialPositionsInABinaryMatrix solution = new SpecialPositionsInABinaryMatrix();

        // when
        int result = solution.numSpecial(mat);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}