package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class FindMinimumInRotatedSortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{3, 4, 5, 1, 2}, 1),
                of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                of(new int[]{11, 13, 15, 17}, 11),
                of(new int[]{2, 1}, 1),
                of(new int[]{5, 1, 2, 3, 4}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void checkInclusion(int[] nums, int expected) {
        // given
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();

        // when
        int result = solution.findMin(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}