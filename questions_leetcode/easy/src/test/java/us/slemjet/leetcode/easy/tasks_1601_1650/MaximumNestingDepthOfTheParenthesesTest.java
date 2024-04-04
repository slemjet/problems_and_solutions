package us.slemjet.leetcode.easy.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MaximumNestingDepthOfTheParenthesesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("(1+(2*3)+((8)/4))+1", 3),
                of("(1)+((2))+(((3)))", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        MaximumNestingDepthOfTheParentheses solution = new MaximumNestingDepthOfTheParentheses();

        // when
        int result = solution.maxDepth(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}