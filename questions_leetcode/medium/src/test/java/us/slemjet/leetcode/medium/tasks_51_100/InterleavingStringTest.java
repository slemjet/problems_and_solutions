package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InterleavingStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
                Arguments.of("aabcc", "dbbca", "aadbbbaccc", false),
                Arguments.of("", "", "", true),
                Arguments.of("", "", "a", false),
                Arguments.of("a", "b", "a", false),
                Arguments.of("db", "b", "cbb", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s1, String s2, String s3, boolean expected) {
        // given
        InterleavingString solution = new InterleavingString();

        // when
        boolean result = solution.isInterleave(s1, s2, s3);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}