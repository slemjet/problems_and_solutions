package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CoinChange2Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5, new int[]{1, 2, 5}, 4),
                Arguments.of(3, new int[]{2}, 0),
                Arguments.of(10, new int[]{10}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testChangeBottomUp(int amount, int[] coins, int expected) {
        // Given
        CoinChange2 solution = new CoinChange2();

        // When
        int result = solution.changeBottomUp(amount, coins);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testChangeBottomUp2(int amount, int[] coins, int expected) {
        // Given
        CoinChange2 solution = new CoinChange2();

        // When
        int result = solution.changeBottomUp2(amount, coins);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTopToBottom2(int amount, int[] coins, int expected) {
        // Given
        CoinChange2 solution = new CoinChange2();

        // When
        int result = solution.changeTopToBottom(amount, coins);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}