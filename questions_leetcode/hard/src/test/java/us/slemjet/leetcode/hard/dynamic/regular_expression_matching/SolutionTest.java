package us.slemjet.leetcode.hard.dynamic.regular_expression_matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SolutionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("aa", "a", false),
                of("aa", "a*", true),
                of("ab", ".*", true),
                of("aab", "c*a*b", true),
                of("mississippi", "mis*is*p*.", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String input1, String input2, boolean expected) {
        // given
        Solution solution = new Solution();

        // when
        boolean matches = solution.isMatch(input1, input2);

        // then
        Assertions.assertThat(matches).isEqualTo(expected);
    }
}