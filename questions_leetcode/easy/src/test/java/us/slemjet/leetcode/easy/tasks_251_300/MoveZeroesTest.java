package us.slemjet.leetcode.easy.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MoveZeroesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 0}, new int[]{1, 0}),
                Arguments.of(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0}, new int[]{4, 2, 4, 3, 5, 1, 0, 0, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMoveZeroes(int[] nums, int[] expected) {
        // given
        MoveZeroes solution = new MoveZeroes();

        // when
        solution.moveZeroes(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMoveZeroes2Pointer(int[] nums, int[] expected) {
        // given
        MoveZeroes solution = new MoveZeroes();

        // when
        solution.moveZeroes2Pointer(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }
}