package us.slemjet.leetcode.hard.from_251_to_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PaintHouseIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 5, 3},
                        new int[]{2, 9, 4}}, 5),
                Arguments.of(new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 4}}, 5),
                Arguments.of(new int[][]{
                        new int[]{1, 3}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] costs, int expected) {
        // given
        PaintHouseII solution = new PaintHouseII();

        // when
        int result = solution.minCostII(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionMemo(int[][] costs, int expected) {
        // given
        PaintHouseII solution = new PaintHouseII();

        // when
        int result = solution.minCostIIMemo(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}