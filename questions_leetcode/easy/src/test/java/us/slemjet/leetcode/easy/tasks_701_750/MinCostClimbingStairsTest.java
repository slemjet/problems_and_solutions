package us.slemjet.leetcode.easy.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinCostClimbingStairsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{10, 15, 20}, 15),
                Arguments.of(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinCostClimbing(int[] cost, int expected) {
        // given
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        // when
        int ways = solution.minCostClimbingStairs(cost);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinCostClimbingStairsBottomUp(int[] cost, int expected) {
        // given
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        // when
        int ways = solution.minCostClimbingStairsBottomUp(cost);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinCostClimbingStairsTopToBottom(int[] cost, int expected) {
        // given
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        // when
        int ways = solution.minCostClimbingStairsTopToBottom(cost);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }
}