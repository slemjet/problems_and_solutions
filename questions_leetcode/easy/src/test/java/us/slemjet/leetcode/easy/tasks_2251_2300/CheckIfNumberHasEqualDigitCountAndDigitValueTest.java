package us.slemjet.leetcode.easy.tasks_2251_2300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CheckIfNumberHasEqualDigitCountAndDigitValueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1210", true),
                Arguments.of("030", false),
                Arguments.of("0020", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String num, boolean expected) {
        // given
        CheckIfNumberHasEqualDigitCountAndDigitValue solution = new CheckIfNumberHasEqualDigitCountAndDigitValue();

        // when
        boolean result = solution.digitCount(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}