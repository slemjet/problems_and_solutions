package us.slemjet.leetcode.hard.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockIVTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new int[]{2, 4, 1}, 2),
                Arguments.of(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfit(int k, int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();

        // when
        int result = solution.maxProfitNaive(k, prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitDpTopDown(int k, int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();

        // when
        int result = solution.maxProfitDpTopDown(k, prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxProfitDpBottomUp(int k, int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();

        // when
        int result = solution.maxProfitDpBottomUp(k, prices);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}