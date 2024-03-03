package us.slemjet.leetcode.hard.tasks_2851_2900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringTransformationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abcd", "cdab", 2, 2),
                Arguments.of("ababab", "ababab", 1, 2),
                Arguments.of("aaacaaabaaacas", "aaaca", 1, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String t, long k, int expected) {
        // given
        StringTransformation solution = new StringTransformation();

        // when
        int result = solution.numberOfWays(s, t, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}