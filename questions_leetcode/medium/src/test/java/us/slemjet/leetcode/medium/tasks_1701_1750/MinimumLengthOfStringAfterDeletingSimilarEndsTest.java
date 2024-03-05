package us.slemjet.leetcode.medium.tasks_1701_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumLengthOfStringAfterDeletingSimilarEndsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("ca", 2),
                Arguments.of("cabaabac", 0),
                Arguments.of("aabccabba", 3),
                Arguments.of("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        MinimumLengthOfStringAfterDeletingSimilarEnds solution = new MinimumLengthOfStringAfterDeletingSimilarEnds();

        // when
        int result = solution.minimumLength(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}