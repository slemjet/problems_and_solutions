package us.slemjet.leetcode.easy.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SearchInsertPositionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),
                Arguments.of(new int[]{1, 3, 5, 6}, 0, 0),
                Arguments.of(new int[]{1}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void searchInsert(int[] nums, int target, int expected) {
        // given
        SearchInsertPosition solution = new SearchInsertPosition();

        // when
        int number = solution.searchInsert(nums, target);

        // then
        Assertions.assertThat(number).isEqualTo(expected);
    }
}
