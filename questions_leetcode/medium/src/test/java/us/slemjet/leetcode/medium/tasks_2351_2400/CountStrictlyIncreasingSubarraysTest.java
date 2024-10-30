package us.slemjet.leetcode.medium.tasks_2351_2400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountStrictlyIncreasingSubarraysTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 4, 4, 6}, 10),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, long expected) {
        // given
        CountStrictlyIncreasingSubarrays solution = new CountStrictlyIncreasingSubarrays();

        // when
        long result = solution.countSubarrays(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}