package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HouseRobberIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{2, 3, 2}, 3),
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 2, 1, 1}, 3),
                Arguments.of(new int[]{4, 1, 2}, 4),
                Arguments.of(new int[]{8, 4, 8, 5, 9, 6, 5, 4, 4, 10}, 34)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRob(int[] nums, int expected) {
        // given
        HouseRobberII solution = new HouseRobberII();

        // when
        int robbed = solution.rob(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRobBottomUp(int[] nums, int expected) {
        // given
        HouseRobberII solution = new HouseRobberII();

        // when
        int robbed = solution.robBottomUp(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRobTopToBottom(int[] nums, int expected) {
        // given
        HouseRobberII solution = new HouseRobberII();

        // when
        int robbed = solution.robTopToBottom(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }
}