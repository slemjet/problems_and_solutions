package us.slemjet.leetcode.medium.tasks_301_350.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_301_350.CoinChange;

import java.util.stream.Stream;

class CoinChangeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // 11 = 5 + 5 + 1
                Arguments.of(new int[]{1, 2, 5}, 11, 3),
                // [411,412,413,414,415,416,417,418,419,420,421,422] -> 9864
                Arguments.of(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864, 24),
                // [431,62,88,428] -> 9084
                Arguments.of(new int[]{431, 62, 88, 428}, 9084, 26),
                Arguments.of(new int[]{2}, 3, -1),
                Arguments.of(new int[]{1}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCoinChange(int[] coins, int amount, int expected) {
        // given
        CoinChange solution = new CoinChange();

        // when
        int result = solution.coinChange(coins, amount);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCoinChangeMemo(int[] coins, int amount, int expected) {
        // given
        CoinChange solution = new CoinChange();

        // when
        int result = solution.coinChangeMemo(coins, amount);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCoinChangeBFS(int[] coins, int amount, int expected) {
        // given
        CoinChange solution = new CoinChange();

        // when
        int result = solution.coinChangeBFS(coins, amount);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}