package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class IntegerReplacementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2147483647, 32),
                Arguments.of(8, 3),
                Arguments.of(7, 4),
                Arguments.of(4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        IntegerReplacement solution = new IntegerReplacement();

        // when
        int result = solution.integerReplacement(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}