package us.slemjet.leetcode.easy.from_301_to_350.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PowerOfThreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(27, true),
                Arguments.of(0, false),
                Arguments.of(9, true),
                Arguments.of(1, true),
                Arguments.of(45, false),
                Arguments.of(2147483647, false),
                Arguments.of(243, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsPowerOfThree(int n, boolean expected) {
        // given
        PowerOfThree solution = new PowerOfThree();

        // when
        boolean result = solution.isPowerOfThree(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsPowerOfLog(int n, boolean expected) {
        // given
        PowerOfThree solution = new PowerOfThree();

        // when
        boolean result = solution.isPowerOfThreeLog(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testIsPowerOfThreeCheat(int n, boolean expected) {
        // given
        PowerOfThree solution = new PowerOfThree();

        // when
        boolean result = solution.isPowerOfThreeCheat(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}