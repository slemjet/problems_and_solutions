package us.slemjet.leetcode.easy.tasks_2701_2750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BuyTwoChocolatesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2}, 3, 0),
                Arguments.of(new int[]{3, 2, 3}, 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] prices, int money, int expected) {
        // given
        BuyTwoChocolates solution = new BuyTwoChocolates();

        // when
        int result = solution.buyChoco(prices, money);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}