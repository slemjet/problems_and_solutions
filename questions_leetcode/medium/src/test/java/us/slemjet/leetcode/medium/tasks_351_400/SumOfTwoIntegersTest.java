package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfTwoIntegersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 3, 5),
                Arguments.of(20, 30, 50),
                Arguments.of(-12, -8, -20)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSum(int a, int b, int expected) {
        // given
        SumOfTwoIntegers solution = new SumOfTwoIntegers();

        // when
        int result = solution.getSum(a, b);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSum2(int a, int b, int expected) {
        // given
        SumOfTwoIntegers solution = new SumOfTwoIntegers();

        // when
        int result = solution.getSum2(a, b);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}