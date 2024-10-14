package us.slemjet.leetcode.medium.tasks_2601_2650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MinimumOperationsToMakeAllArrayElementsEqualTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 6, 8}, new int[]{1, 5}, List.of(14L, 10L)),
                Arguments.of(new int[]{2, 9, 6, 3}, new int[]{10}, List.of(20L))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] queries, List<Long> expected) {
        // given
        MinimumOperationsToMakeAllArrayElementsEqual solution = new MinimumOperationsToMakeAllArrayElementsEqual();

        // when
        List<Long> result = solution.minOperations(nums, queries);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}