package us.slemjet.leetcode.easy.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumProductOfTwoElementsInAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 4, 5, 2}, 12),
                Arguments.of(new int[]{1, 5, 4, 5}, 16),
                Arguments.of(new int[]{3, 7}, 12),
                Arguments.of(new int[]{10, 2, 5, 2}, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        MaximumProductOfTwoElementsInAnArray solution = new MaximumProductOfTwoElementsInAnArray();

        // when
        int result = solution.maxProduct(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSort(int[] nums, int expected) {
        // given
        MaximumProductOfTwoElementsInAnArray solution = new MaximumProductOfTwoElementsInAnArray();

        // when
        int result = solution.maxProductSort(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}