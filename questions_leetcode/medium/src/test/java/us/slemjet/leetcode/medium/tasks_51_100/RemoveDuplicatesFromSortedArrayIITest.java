package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedArrayIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 5),
                Arguments.of(new int[]{1, 2, 2}, 3),
                Arguments.of(new int[]{1, 1, 2, 2, 3, 3}, 6),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, 7),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 2, 3, 3}, 6));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveDuplicates(int[] nums, int expected) {
        // given
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();

        // when
        int result = solution.removeDuplicates(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveDuplicatesMinimalistic(int[] nums, int expected) {
        // given
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();

        // when
        int result = solution.removeDuplicatesMinimalistic(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}