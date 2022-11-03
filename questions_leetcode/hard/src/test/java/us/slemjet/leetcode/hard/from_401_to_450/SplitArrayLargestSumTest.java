package us.slemjet.leetcode.hard.from_401_to_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SplitArrayLargestSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{7, 2, 5, 10, 8}, 2, 18),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSplitArrayBinary(int[] nums, int k, int expected) {
        // given
        SplitArrayLargestSum solution = new SplitArrayLargestSum();

        // when
        int result = solution.splitArrayBinary(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSplitArrayDfs(int[] nums, int k, int expected) {
        // given
        SplitArrayLargestSum solution = new SplitArrayLargestSum();

        // when
        int result = solution.splitArrayDfs(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}