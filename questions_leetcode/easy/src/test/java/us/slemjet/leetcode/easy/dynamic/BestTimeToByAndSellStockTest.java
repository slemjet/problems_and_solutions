package us.slemjet.leetcode.easy.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BestTimeToByAndSellStockTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void climbStairs(int[] prices, int expected) {
        // given
        BestTimeToByAndSellStock solution = new BestTimeToByAndSellStock();

        // when
        int maxProfit = solution.maxProfit(prices);

        // then
        Assertions.assertThat(maxProfit).isEqualTo(expected);
    }
}