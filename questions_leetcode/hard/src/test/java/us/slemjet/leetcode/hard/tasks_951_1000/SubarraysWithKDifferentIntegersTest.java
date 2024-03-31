package us.slemjet.leetcode.hard.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SubarraysWithKDifferentIntegersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 1, 2, 3}, 2, 7),
                of(new int[]{1, 2, 1, 3, 4}, 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, int expected) {
        // given
        SubarraysWithKDifferentIntegers solution = new SubarraysWithKDifferentIntegers();

        // when
        int result = solution.subarraysWithKDistinct(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}