package us.slemjet.leetcode.medium.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumSumCircularSubarrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, -2, 3, -2}, 3),
                Arguments.of(new int[]{5, -3, 5}, 10),
                Arguments.of(new int[]{3, -1, 2, -1}, 4),
                Arguments.of(new int[]{3, -2, 2, -3}, 3),
                Arguments.of(new int[]{-2, -3, -1}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxSubarraySumCircular(int[] A, int expected) {
        // given
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();

        // when
        int result = solution.maxSubarraySumCircular(A);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
