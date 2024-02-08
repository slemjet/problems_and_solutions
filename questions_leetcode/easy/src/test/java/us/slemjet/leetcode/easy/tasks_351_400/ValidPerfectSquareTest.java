package us.slemjet.leetcode.easy.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidPerfectSquareTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(5, false),
                Arguments.of(16, true),
                Arguments.of(14, false),
                Arguments.of(808201, true),
                Arguments.of(2147483647, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPerfectSquareNewton(int num, boolean expected) {
        // given
        ValidPerfectSquare solution = new ValidPerfectSquare();

        // when
        boolean result = solution.isPerfectSquareNewton(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPerfectSquareSubstr(int num, boolean expected) {
        // given
        ValidPerfectSquare solution = new ValidPerfectSquare();

        // when
        boolean result = solution.isPerfectSquareSubstr(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void isPerfectSquareBinary(int num, boolean expected) {
        // given
        ValidPerfectSquare solution = new ValidPerfectSquare();

        // when
        boolean result = solution.isPerfectSquareBinary(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
