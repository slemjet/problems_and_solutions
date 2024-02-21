package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BitwiseANDOfNumbersRangeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(5, 7, 4),
                Arguments.of(381, 393, 256),
                Arguments.of(103, 393, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(5, 5, 5),
                Arguments.of(1, 2147483647, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int left, int right, int expected) {
        // given
        BitwiseANDOfNumbersRange solution = new BitwiseANDOfNumbersRange();

        // when
        int result = solution.rangeBitwiseAnd(left, right);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionWithStrings(int left, int right, int expected) {
        // given
        BitwiseANDOfNumbersRange solution = new BitwiseANDOfNumbersRange();

        // when
        int result = solution.rangeBitwiseAndWithStrings(left, right);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}