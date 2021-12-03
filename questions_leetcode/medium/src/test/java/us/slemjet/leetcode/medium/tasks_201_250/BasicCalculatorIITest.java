package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BasicCalculatorIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2*3+4", 10),
                Arguments.of("0", 0),
                Arguments.of("0-2147483647", -2147483647),
                Arguments.of("3+2*2", 7),
                Arguments.of(" 3/2 ", 1),
                Arguments.of(" 3+5 / 2 ", 5),
                Arguments.of(" 3+5 / 2 + 6 -4/2 ", 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCalculate(String s, int expected) {
        // given
        BasicCalculatorII solution = new BasicCalculatorII();

        // when
        int result = solution.calculate(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}