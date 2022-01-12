package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JumpGameIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
                Arguments.of(new int[]{2, 3, 0, 1, 4}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJump(int[] nums, int expected) {
        // given
        JumpGameII solution = new JumpGameII();

        // when
        int result = solution.jump(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJumpBottomUp(int[] nums, int expected) {
        // given
        JumpGameII solution = new JumpGameII();

        // when
        int result = solution.jumpBottomUp(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJumpBottomUp2(int[] nums, int expected) {
        // given
        JumpGameII solution = new JumpGameII();

        // when
        int result = solution.jumpBottomUp2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testJumpTopToBottom(int[] nums, int expected) {
        // given
        JumpGameII solution = new JumpGameII();

        // when
        int result = solution.jumpTopToBottom(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void jump2(int[] nums, int expected) {
        // given
        JumpGameII solution = new JumpGameII();

        // when
        int result = solution.jump2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
