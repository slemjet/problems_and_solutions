package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class LargestDivisibleSubsetTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, List.of(1, 2)),
                Arguments.of(new int[]{1, 2, 4, 8}, List.of(1, 2, 4, 8)),
                Arguments.of(new int[]{5, 9, 18, 54, 108, 540, 90, 180, 360, 720}, List.of(9, 18, 90, 180, 360, 720))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(int[] nums, List<Integer> expected) {
        // given
        LargestDivisibleSubset solution = new LargestDivisibleSubset();

        // when
        List<Integer> result = solution.largestDivisibleSubset(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}