package us.slemjet.leetcode.easy.from_1701_to_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculateMoneyInLeetcodeBankTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, 10),
                Arguments.of(10, 37),
                Arguments.of(20, 96),
                Arguments.of(26, 135)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        CalculateMoneyInLeetcodeBank solution = new CalculateMoneyInLeetcodeBank();

        // when
        int result = solution.totalMoney(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}