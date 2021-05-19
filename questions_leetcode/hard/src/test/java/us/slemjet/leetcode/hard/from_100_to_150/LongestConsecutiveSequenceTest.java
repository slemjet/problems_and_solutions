package us.slemjet.leetcode.hard.from_100_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * 128. Longest Consecutive Sequence
 */
class LongestConsecutiveSequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void longestConsecutiveTest(int[] nums, int expected) {
        // given
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // when
        int result = solution.longestConsecutive(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void longestConsecutiveHashTest(int[] nums, int expected) {
        // given
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // when
        int result = solution.longestConsecutiveHash(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
