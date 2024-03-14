package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinarySubarraysWithSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 1, 0, 1}, 2, 4),
                Arguments.of(new int[]{0, 0, 0, 0, 0}, 0, 15),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int goal, int expected) {
        // given
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();

        // when
        int result = solution.numSubarraysWithSum(nums, goal);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}