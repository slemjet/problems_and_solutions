package us.slemjet.leetcode.hard.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SlidingWindowMaximumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,3,-1,-3,5,3,6,7], k = 3 -> Output: [3,3,5,5,6,7]
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                // [1], k = 1 -> Output: [1]
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                // [1,-1], k = 1 -> Output: [1,-1]
                Arguments.of(new int[]{1, -1}, 1, new int[]{1, -1}),
                // [9,11], k = 2 -> Output: [11]
                Arguments.of(new int[]{9, 11}, 2, new int[]{11}),
                // [4,-2], k = 2 -> Output: [4]
                Arguments.of(new int[]{4, -2}, 2, new int[]{4}),
                // [-7,-8,7,5,7,1,6,0], k = 4 -> [7,7,7,7,7]
                Arguments.of(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4, new int[]{7, 7, 7, 7, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxSlidingWindow(int[] nums, int k, int[] expected) {
        // given
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        // when
        int[] result = solution.maxSlidingWindow(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}