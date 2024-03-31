package us.slemjet.leetcode.hard.tasks_2401_2450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class CountSubarraysWithFixedBoundsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 3, 5, 2, 7, 5}, 1, 5, 2L),
                of(new int[]{1, 1, 1, 1}, 1, 1, 10L)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int minK, int maxK, long expected) {
        // given
        CountSubarraysWithFixedBounds solution = new CountSubarraysWithFixedBounds();

        // when
        long result = solution.countSubarrays(nums, minK, maxK);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}