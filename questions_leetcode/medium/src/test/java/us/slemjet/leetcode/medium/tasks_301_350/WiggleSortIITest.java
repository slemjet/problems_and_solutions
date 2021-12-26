package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WiggleSortIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: nums = [1,5,1,1,6,4] -> Output: [1,6,1,5,1,4] ([1,4,1,5,1,6] is also accepted)
                Arguments.of(new int[]{1, 5, 1, 1, 6, 4}, new int[]{1, 6, 1, 5, 1, 4}),
                // Input: nums = [1,3,2,2,3,1] -> Output: [2,3,1,3,1,2]
                Arguments.of(new int[]{1, 3, 2, 2, 3, 1}, new int[]{2, 3, 1, 3, 1, 2}),
                // Input: nums = [1,1,2,1,2,2,1] -> Output: [1, 2, 1, 2, 1, 2, 1]
                Arguments.of(new int[]{1, 1, 2, 1, 2, 2, 1}, new int[]{1, 2, 1, 2, 1, 2, 1}),
                // Input: nums = [5,6,1] -> Output: [5,6,1]
                Arguments.of(new int[]{5, 6, 1}, new int[]{5, 6, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWiggleSort(int[] nums, int[] expected) {
        // given
        WiggleSortII solution = new WiggleSortII();

        // when
        solution.wiggleSort(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWiggleSortNaive(int[] nums, int[] expected) {
        // given
        WiggleSortII solution = new WiggleSortII();

        // when
        solution.wiggleSortNaive(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }

}