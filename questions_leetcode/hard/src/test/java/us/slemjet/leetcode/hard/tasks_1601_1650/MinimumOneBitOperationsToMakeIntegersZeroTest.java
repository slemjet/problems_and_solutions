package us.slemjet.leetcode.hard.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumOneBitOperationsToMakeIntegersZeroTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(3, 2),
                Arguments.of(6, 4),
                Arguments.of(7, 5),
                Arguments.of(23, 26)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        MinimumOneBitOperationsToMakeIntegersZero solution = new MinimumOneBitOperationsToMakeIntegersZero();

        // when
        int result = solution.minimumOneBitOperations(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}