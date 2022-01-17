package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockWithTransactionFeeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 2, 8, 4, 9}, 2, 8),
                Arguments.of(new int[]{1, 3, 7, 5, 10, 3}, 3, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfit(int[] prices, int fee, int expected) {
        // given
        BestTimeToBuyAndSellStockWithTransactionFee solution = new BestTimeToBuyAndSellStockWithTransactionFee();

        // when
        int result = solution.maxProfit(prices, fee);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitConstantSpace(int[] prices, int fee, int expected) {
        // given
        BestTimeToBuyAndSellStockWithTransactionFee solution = new BestTimeToBuyAndSellStockWithTransactionFee();

        // when
        int result = solution.maxProfitConstantSpace(prices, fee);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}