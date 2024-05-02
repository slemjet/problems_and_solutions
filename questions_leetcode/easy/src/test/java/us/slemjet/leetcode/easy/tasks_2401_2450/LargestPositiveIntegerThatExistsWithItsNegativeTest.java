package us.slemjet.leetcode.easy.tasks_2401_2450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LargestPositiveIntegerThatExistsWithItsNegativeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, -3, 3}, 3),
                Arguments.of(new int[]{-1, 10, 6, 7, -7, 1}, 7),
                Arguments.of(new int[]{-10, 8, 6, 7, -2, -3}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        LargestPositiveIntegerThatExistsWithItsNegative solution = new LargestPositiveIntegerThatExistsWithItsNegative();

        // when
        int result = solution.findMaxK(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}