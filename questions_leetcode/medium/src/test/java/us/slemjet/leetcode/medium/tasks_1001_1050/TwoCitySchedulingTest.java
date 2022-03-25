package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TwoCitySchedulingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{10, 20}, new int[]{30, 200}, new int[]{400, 50}, new int[]{30, 20}}, 110),
                Arguments.of(new int[][]{
                        new int[]{259, 770}, new int[]{448, 54}, new int[]{926, 667},
                        new int[]{184, 139}, new int[]{840, 118}, new int[]{577, 469}}, 1859),
                Arguments.of(new int[][]{
                        new int[]{515, 563}, new int[]{451, 713}, new int[]{537, 709}, new int[]{343, 819},
                        new int[]{855, 779}, new int[]{457, 60}, new int[]{650, 359}, new int[]{631, 42}}, 3086)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTwoCitySchedCost(int[][] costs, int expected) {
        // given
        TwoCityScheduling solution = new TwoCityScheduling();

        // when
        int result = solution.twoCitySchedCost(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTwoCitySchedCostBottomUp(int[][] costs, int expected) {
        // given
        TwoCityScheduling solution = new TwoCityScheduling();

        // when
        int result = solution.twoCitySchedCostBottomUp(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTwoCitySchedCostTopToBottom(int[][] costs, int expected) {
        // given
        TwoCityScheduling solution = new TwoCityScheduling();

        // when
        int result = solution.twoCitySchedCostTopToBottom(costs);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}