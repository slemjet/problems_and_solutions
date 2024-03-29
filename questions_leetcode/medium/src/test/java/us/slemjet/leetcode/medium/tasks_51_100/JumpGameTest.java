package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpGameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, true),
                Arguments.of(new int[]{3, 2, 1, 0, 4}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanJump(int[] nums, boolean expected) {
        // given
        JumpGame solution = new JumpGame();

        // when
        boolean result = solution.canJump(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCanJumpBottomUp(int[] nums, boolean expected) {
        // given
        JumpGame solution = new JumpGame();

        // when
        boolean result = solution.canJumpBottomUp(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
