package us.slemjet.leetcode.easy.from_101_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToBuyAndSellStockIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxProfitTest(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

        // when
        int maxProfit = solution.maxProfit(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxProfitBruteTest(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

        // when
        int maxProfit = solution.maxProfitBrute(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxProfitSumsTest(int[] prices, int expected) {
        // given
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();

        // when
        int maxProfit = solution.maxProfitSums(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }
}
