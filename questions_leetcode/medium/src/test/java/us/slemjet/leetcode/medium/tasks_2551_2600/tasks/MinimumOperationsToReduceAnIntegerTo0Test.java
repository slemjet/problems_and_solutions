package us.slemjet.leetcode.medium.tasks_2551_2600.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumOperationsToReduceAnIntegerTo0Test {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(39, 3),
                Arguments.of(54, 3),
                Arguments.of(70, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        MinimumOperationsToReduceAnIntegerTo0 solution = new MinimumOperationsToReduceAnIntegerTo0();

        // when
        int result = solution.minOperations(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}