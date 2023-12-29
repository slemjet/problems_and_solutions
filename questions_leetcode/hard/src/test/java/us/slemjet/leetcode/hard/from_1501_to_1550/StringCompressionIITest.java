package us.slemjet.leetcode.hard.from_1501_to_1550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringCompressionIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aaabcccd", 2, 4),
                Arguments.of("aabbaa", 2, 2),
                Arguments.of("aaaaaaaaaaa", 0, 3),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(String s, int k, int expected) {
        // given
        StringCompressionII solution = new StringCompressionII();

        // when
        int result = solution.getLengthOfOptimalCompressionTopDown(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(String s, int k, int expected) {
        // given
        StringCompressionII solution = new StringCompressionII();

        // when
        int result = solution.getLengthOfOptimalCompressionBottomUp(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}