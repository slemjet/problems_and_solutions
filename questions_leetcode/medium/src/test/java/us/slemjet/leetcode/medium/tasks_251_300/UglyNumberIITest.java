package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UglyNumberIITest {


    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(10, 12),
                Arguments.of(1, 1),
                Arguments.of(500, 937500),
                Arguments.of(1000, 51200000),
                Arguments.of(1300, 306110016),
                Arguments.of(1407, 536870912)
                );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNthUglyNumber(int n, int expected) {
        // given
        UglyNumberII solution = new UglyNumberII();

        // when
        int result = solution.nthUglyNumber(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNthUglyNumber2(int n, int expected) {
        // given
        UglyNumberII solution = new UglyNumberII();

        // when
        int result = solution.nthUglyNumber2(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}