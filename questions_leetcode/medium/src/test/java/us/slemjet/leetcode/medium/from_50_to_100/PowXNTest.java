package us.slemjet.leetcode.medium.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.offset;

class PowXNTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2.00000, 10, 1024.00000),
                Arguments.of(2.10000, 3, 9.26100),
                Arguments.of(2.00000, -2, 0.25000),
                Arguments.of(0.44528, 0, 1),
                Arguments.of(1.00000, 2147483647, 1),
                Arguments.of(-1.00000, 2147483647, -1),
                Arguments.of(2.00000, -2147483648, 0),
                Arguments.of(34.00515, -3, 0.00003)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void myPow(double x, int n, double expected) {
        // given
        PowXN solution = new PowXN();

        // when
        double result = solution.myPow(x, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected, offset(0.00001));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void myPow2(double x, int n, double expected) {
        // given
        PowXN solution = new PowXN();

        // when
        double result = solution.myPow2(x, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected, offset(0.00001));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void myPow3(double x, int n, double expected) {
        // given
        PowXN solution = new PowXN();

        // when
        double result = solution.myPow3(x, n);

        // then
        Assertions.assertThat(result).isEqualTo(expected, offset(0.00001));
    }
}
