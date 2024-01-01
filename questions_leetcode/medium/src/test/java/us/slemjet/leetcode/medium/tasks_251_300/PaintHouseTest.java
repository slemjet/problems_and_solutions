package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PaintHouseTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{17, 2, 17},
                        new int[]{16, 16, 5},
                        new int[]{14, 3, 19}}, 10),
                Arguments.of(new int[][]{
                        new int[]{7, 6, 2}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(int[][] costs, int expected) {
        // given
        PaintHouse solution = new PaintHouse();

        // when
        int result = solution.minCostBottomUp(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionMemo(int[][] costs, int expected) {
        // given
        PaintHouse solution = new PaintHouse();

        // when
        int result = solution.minCostMemo(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}