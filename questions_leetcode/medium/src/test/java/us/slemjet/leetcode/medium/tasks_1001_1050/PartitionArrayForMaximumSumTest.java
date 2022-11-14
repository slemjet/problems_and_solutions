package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PartitionArrayForMaximumSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 15, 7, 9, 2, 5, 10}, 3, 84),
                Arguments.of(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83),
                Arguments.of(new int[]{1}, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxSumAfterPartitioning(int[] arr, int k, int expected) {
        // given
        PartitionArrayForMaximumSum solution = new PartitionArrayForMaximumSum();

        // when
        int result = solution.maxSumAfterPartitioning(arr, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}