package us.slemjet.leetcode.easy.tasks_1901_1950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumProductDifferenceBetweenTwoPairsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{5, 6, 2, 7, 4}, 34),
                Arguments.of(new int[]{4, 2, 5, 9, 7, 4, 8}, 64)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        MaximumProductDifferenceBetweenTwoPairs solution = new MaximumProductDifferenceBetweenTwoPairs();

        // when
        int result = solution.maxProductDifference(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}