package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaxConsecutiveOnesIIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
                Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSliding(int[] nums, int k, int expected) {
        // given
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();

        // when
        int result = solution.longestOnesSliding(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}