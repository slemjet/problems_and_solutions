package us.slemjet.leetcode.hard.from_301_to_350.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_301_to_350.CountOfSmallerNumbersAfterSelf;

import java.util.List;
import java.util.stream.Stream;

class CountOfSmallerNumbersAfterSelfTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: nums = [5,2,6,1] -> Output: [2,1,1,0]
                Arguments.of(new int[]{5, 2, 6, 1}, List.of(2, 1, 1, 0)),
                // Input: nums = [0,2,1] -> Output: [0,1,0]
                Arguments.of(new int[]{0, 2, 1}, List.of(0, 1, 0)),
                // Input: nums = [3, 2, 2, 6, 1] -> Output: [0,1,0]
                Arguments.of(new int[]{3, 2, 2, 6, 1}, List.of(3, 1, 1, 1, 0)),
                // Input: nums = [-1] -> Output: [0]
                Arguments.of(new int[]{-1}, List.of(0)),
                // Input: nums = [-1,-1] -> Output: [0,0]
                Arguments.of(new int[]{-1, -1}, List.of(0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountSmaller(int[] nums, List<Integer> expected) {
        // given
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();

        // when
        List<Integer> result = solution.countSmaller(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}