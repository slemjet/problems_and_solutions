package us.slemjet.leetcode.hard.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class TrappingRainWaterTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                of(new int[]{4, 2, 3}, 1),
                of(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void trapTest(int[] nums, int expected) {
        // given
        TrappingRainWater solution = new TrappingRainWater();

        // when
        int result = solution.trap(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void trap2Test(int[] nums, int expected) {
        // given
        TrappingRainWater solution = new TrappingRainWater();

        // when
        int result = solution.trap2(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
