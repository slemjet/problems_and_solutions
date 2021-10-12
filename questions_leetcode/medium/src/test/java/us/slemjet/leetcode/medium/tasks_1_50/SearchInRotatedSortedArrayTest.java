package us.slemjet.leetcode.medium.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInRotatedSortedArrayTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(new int[]{3, 1}, 3, 0),
                Arguments.of(new int[]{3, 5, 1}, 3, 0),
                Arguments.of(new int[]{5, 1, 3}, 3, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int target, int expected) {
        // given
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

        // when
        int result = solution.search(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionShiftFirst(int[] nums, int target, int expected) {
        // given
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

        // when
        int result = solution.searchShiftFirst(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
