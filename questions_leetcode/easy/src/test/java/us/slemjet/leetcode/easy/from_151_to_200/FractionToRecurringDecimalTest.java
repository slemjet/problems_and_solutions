package us.slemjet.leetcode.easy.from_151_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class FractionToRecurringDecimalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(-1, -2147483648, "0.0000000004656612873077392578125"),
                Arguments.of(-22, -2, "11"),
                Arguments.of(0, -5, "0"),
                Arguments.of(0, 3, "0"),
                Arguments.of(1, 333, "0.(003)"),
                Arguments.of(1, 2, "0.5"),
                Arguments.of(2, 1, "2"),
                Arguments.of(2, 3, "0.(6)"),
                Arguments.of(4, 333, "0.(012)"),
                Arguments.of(1, 5, "0.2")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsFractionToDecimal(int numerator, int denominator, String expected) {
        // given
        FractionToRecurringDecimal solution = new FractionToRecurringDecimal();

        // when
        String result = solution.fractionToDecimal(numerator, denominator);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}