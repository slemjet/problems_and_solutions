package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RotateArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}),
                Arguments.of(new int[]{1, 2, 3}, 0, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsRotate(int[] nums, int k, int[] expected) {
        // given
        RotateArray solution = new RotateArray();

        // when
        solution.rotate(nums, k);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsRotateSeparate(int[] nums, int k, int[] expected) {
        // given
        RotateArray solution = new RotateArray();

        // when
        solution.rotateSeparate(nums, k);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }
}