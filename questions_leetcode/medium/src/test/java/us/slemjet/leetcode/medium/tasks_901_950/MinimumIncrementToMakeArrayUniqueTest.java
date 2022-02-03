package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MinimumIncrementToMakeArrayUniqueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 2, 2}, 1),
                of(new int[]{3, 2, 1, 2, 1, 7}, 6),
                of(new int[]{2, 2, 2, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findMinIncrementForUnique(int[] nums, int expected) {
        // given
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();

        // when
        int result = solution.minIncrementForUnique(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findMinIncrementForUniqueBuckets(int[] nums, int expected) {
        // given
        MinimumIncrementToMakeArrayUnique solution = new MinimumIncrementToMakeArrayUnique();

        // when
        int result = solution.minIncrementForUniqueBuckets(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}