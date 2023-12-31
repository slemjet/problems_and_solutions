package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DifferentWaysToAddParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2-1-1", List.of(0, 2)),
                Arguments.of("2*3-4*5", List.of(-34, -14, -10, -10, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(String expression, List<Integer> expected) {
        // given
        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();

        // when
        List<Integer> result = solution.diffWaysToCompute(expression);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}