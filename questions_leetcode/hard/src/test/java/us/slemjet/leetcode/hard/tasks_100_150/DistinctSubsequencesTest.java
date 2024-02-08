package us.slemjet.leetcode.hard.tasks_100_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DistinctSubsequencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("rabbbit", "rabbit", 3),
                Arguments.of("babgbag", "bag", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String t, int expected) {
        // given
        DistinctSubsequences solution = new DistinctSubsequences();

        // when
        int result = solution.numDistinct(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}