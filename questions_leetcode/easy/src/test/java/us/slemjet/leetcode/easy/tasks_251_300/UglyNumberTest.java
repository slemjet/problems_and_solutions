package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UglyNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(6, true),
                Arguments.of(1, true),
                Arguments.of(14, false),
                Arguments.of(0, false),
                Arguments.of(-2147483648, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsUgly(int n, boolean expected) {
        // given
        UglyNumber solution = new UglyNumber();

        // when
        boolean result = solution.isUgly(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}