package us.slemjet.leetcode.medium.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BrokenCalculatorTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 3, 2),
                Arguments.of(5, 8, 2),
                Arguments.of(3, 10, 3),
                Arguments.of(1024, 1, 1023)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testBrokenCalc(int startValue, int target, int expected) {
        // given
        BrokenCalculator solution = new BrokenCalculator();

        // when
        int result = solution.brokenCalc(startValue, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}