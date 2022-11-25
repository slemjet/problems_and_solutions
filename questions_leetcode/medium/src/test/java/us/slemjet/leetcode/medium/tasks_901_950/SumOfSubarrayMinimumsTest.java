package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfSubarrayMinimumsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 4),
                Arguments.of(new int[]{2, 1}, 4),
                Arguments.of(new int[]{3, 1, 2, 4}, 17),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 35),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, 35),
                Arguments.of(new int[]{11, 81, 94, 43, 3}, 444)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSumSubarrayMins(int[] arr, int expected) {
        // given
        SumOfSubarrayMinimums solution = new SumOfSubarrayMinimums();

        // when
        int result = solution.sumSubarrayMins(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSumSubarrayMinsDp(int[] arr, int expected) {
        // given
        SumOfSubarrayMinimums solution = new SumOfSubarrayMinimums();

        // when
        int result = solution.sumSubarrayMinsDp(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}