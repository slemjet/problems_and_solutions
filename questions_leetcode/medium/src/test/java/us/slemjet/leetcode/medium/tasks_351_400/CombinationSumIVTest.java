package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CombinationSumIVTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 4, 7),
                Arguments.of(new int[]{9}, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCombinationSum4(int[] nums, int target, int expected) {
        // given
        CombinationSumIV solution = new CombinationSumIV();

        // when
        int result = solution.combinationSum4BottomUp(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCombinationSum4TopToBottom(int[] nums, int target, int expected) {
        // given
        CombinationSumIV solution = new CombinationSumIV();

        // when
        int result = solution.combinationSum4TopToBottom(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}