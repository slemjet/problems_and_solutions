package us.slemjet.leetcode.hard.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BasicCalculatorTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of(" 2-1 + 2 ", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23),
                Arguments.of("1-(     -2)", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCalculate(String s, int expected) {
        // given
        BasicCalculator solution = new BasicCalculator();

        // when
        int result = solution.calculate(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}