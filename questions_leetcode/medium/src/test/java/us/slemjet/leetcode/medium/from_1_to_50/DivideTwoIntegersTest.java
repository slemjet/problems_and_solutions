package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DivideTwoIntegersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(10, 3, 3),
                Arguments.of(7, -3, -2),
                Arguments.of(1, 1, 1),
                Arguments.of(-2147483648, -1, 2147483647),
                Arguments.of(2147483647, 1, 2147483647),
                Arguments.of(2147483647, 2, 1073741823),
                Arguments.of(-2147483648, 2, -1073741824)

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDivide(int dividend, int divisor, int expected) {
        // given
        DivideTwoIntegers solution = new DivideTwoIntegers();

        // when
        int result = solution.divide(dividend, divisor);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
