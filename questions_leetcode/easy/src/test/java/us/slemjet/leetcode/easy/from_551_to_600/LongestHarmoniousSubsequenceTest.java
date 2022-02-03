package us.slemjet.leetcode.easy.from_551_to_600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class LongestHarmoniousSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 3, 2, 2, 5, 2, 3, 7}, 5),
                of(new int[]{1, 2, 3, 4}, 2),
                of(new int[]{1, 1, 1, 1}, 0),
                of(new int[]{1, 2, 2, 1}, 4),
                of(new int[]{1, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindLHS(int[] nums, int expected) {
        // given
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();

        // when
        int result = solution.findLHS(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindLHSSlidingWindow(int[] nums, int expected) {
        // given
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();

        // when
        int result = solution.findLHSSlidingWindow(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindLHSSort(int[] nums, int expected) {
        // given
        LongestHarmoniousSubsequence solution = new LongestHarmoniousSubsequence();

        // when
        int result = solution.findLHSSort(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}