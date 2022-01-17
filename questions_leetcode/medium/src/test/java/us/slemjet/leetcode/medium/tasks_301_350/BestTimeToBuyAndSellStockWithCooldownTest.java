package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockWithCooldownTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 2}, 3),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{2, 1}, 0),
                Arguments.of(new int[]{3, 2, 1}, 0),
                Arguments.of(new int[]{1, 4, 2}, 3),
                Arguments.of(new int[]{6, 1, 3, 2, 4, 7}, 6),
                Arguments.of(new int[]{2, 1, 4, 5, 2, 9, 7}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfit(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();

        // when
        int result = solution.maxProfit(prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitOptimizedSpace(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();

        // when
        int result = solution.maxProfitOptimizedSpace(prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}