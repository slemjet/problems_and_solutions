package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInRotatedSortedArrayIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
                Arguments.of(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false),
                Arguments.of(new int[]{1, 0, 1, 1, 1}, 0, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSearch(int[] nums, int target, boolean expected) {
        // given
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();

        // when
        boolean result = solution.search(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}