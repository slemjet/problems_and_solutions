package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LongestIncreasingSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                Arguments.of(new int[]{0, 1, 0, 3, 2, 3}, 4),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 1),
                Arguments.of(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLengthOfLIS(int[] nums, int expected) {
        // given
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        // when
        int result = solution.lengthOfLIS(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testLengthOfLISNaive(int[] nums, int expected) {
        // given
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();

        // when
        int result = solution.lengthOfLISNaive(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}