package us.slemjet.leetcode.medium.tasks_2851_2900.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfOperationsToMakeArrayEmptyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}, 4),
                Arguments.of(new int[]{2, 1, 2, 2, 3, 3}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        MinimumNumberOfOperationsToMakeArrayEmpty solution = new MinimumNumberOfOperationsToMakeArrayEmpty();

        // when
        int result = solution.minOperations(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}