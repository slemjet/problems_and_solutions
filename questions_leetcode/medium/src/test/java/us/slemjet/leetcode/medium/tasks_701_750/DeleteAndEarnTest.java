package us.slemjet.leetcode.medium.tasks_701_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DeleteAndEarnTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{10000}, 10000),
                Arguments.of(new int[]{3, 1}, 4),
                Arguments.of(new int[]{3, 4, 2}, 6),
                Arguments.of(new int[]{2, 2, 3, 3, 3, 4}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDeleteAndEarn(int[] nums, int expected) {
        // given
        DeleteAndEarn solution = new DeleteAndEarn();

        // when
        int robbed = solution.deleteAndEarn(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDeleteAndEarnBottomUp(int[] nums, int expected) {
        // given
        DeleteAndEarn solution = new DeleteAndEarn();

        // when
        int robbed = solution.deleteAndEarnBottomUp(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDeleteAndEarnTopToBottom(int[] nums, int expected) {
        // given
        DeleteAndEarn solution = new DeleteAndEarn();

        // when
        int robbed = solution.deleteAndEarnTopToBottom(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }

}