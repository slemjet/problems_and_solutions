package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PalindromePartitioningIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aab", 1),
                Arguments.of("a", 0),
                Arguments.of("ab", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        PalindromePartitioningII solution = new PalindromePartitioningII();

        // when
        int result = solution.minCut(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}