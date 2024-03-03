package us.slemjet.leetcode.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class KMPStringMatchTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abcd", "cdab", List.of()),
                Arguments.of("ababab", "ababab", List.of(0)),
                Arguments.of("aaacaaabaaacas", "aaaca", List.of(0, 8)),
                Arguments.of("AAAAAAAAAAAAAAAAAA", "AAAAA", List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)),
                Arguments.of("AAAAAAAAAAAAAAAAAB", "AAAAA", List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String str, String pat, List<Integer> expected) {

        // when
        List<Integer> result = KMPStringMatch.findMatches(str, pat);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}