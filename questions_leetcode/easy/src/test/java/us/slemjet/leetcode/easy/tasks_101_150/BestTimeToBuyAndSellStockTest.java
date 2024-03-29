package us.slemjet.leetcode.easy.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfit(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // when
        int maxProfit = solution.maxProfit(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitBottomUp(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // when
        int maxProfit = solution.maxProfitBottomUp(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitKadane(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // when
        int maxProfit = solution.maxProfitKadane(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }
}
