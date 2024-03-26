package us.slemjet.leetcode.hard.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class FirstMissingPositiveTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{}, 1),
                of(new int[]{1}, 2),
                of(new int[]{0, 1, 2}, 3),
                of(new int[]{4, 1, 5, 0, 6, 2}, 3),
                of(new int[]{0}, 1),
                of(new int[]{1, 1}, 2),
                of(new int[]{1, 2, 0}, 3),
                of(new int[]{3, 4, -1, 1}, 2),
                of(new int[]{7, 8, 9, 11, 12}, 1),
                of(new int[]{3, 4, -1, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void firstMissingPositive(int[] nums, int expected) {
        // given
        FirstMissingPositive solution = new FirstMissingPositive();

        // when
        int result = solution.firstMissingPositive(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void firstMissingPositiveIndexByValueAndSwap(int[] nums, int expected) {
        // given
        FirstMissingPositive solution = new FirstMissingPositive();

        // when
        int result = solution.firstMissingPositiveIndexByValueAndSwap(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution3(int[] nums, int expected) {
        // given
        FirstMissingPositive solution = new FirstMissingPositive();

        // when
        int result = solution.firstMissingPositive3(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
