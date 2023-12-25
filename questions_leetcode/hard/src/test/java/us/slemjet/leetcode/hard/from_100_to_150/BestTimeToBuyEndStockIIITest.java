package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyEndStockIIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] prices, int expected) {
        // given
        BestTimeToBuyEndStockIII solution = new BestTimeToBuyEndStockIII();

        // when
        int result = solution.maxProfit(prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionGpt(int[] prices, int expected) {
        // given
        BestTimeToBuyEndStockIII solution = new BestTimeToBuyEndStockIII();

        // when
        int result = solution.maxProfit2(prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}