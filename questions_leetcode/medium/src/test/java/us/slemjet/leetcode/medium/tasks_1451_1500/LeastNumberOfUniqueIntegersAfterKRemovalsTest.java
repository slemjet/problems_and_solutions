package us.slemjet.leetcode.medium.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LeastNumberOfUniqueIntegersAfterKRemovalsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 4}, 1, 1),
                Arguments.of(new int[]{4, 3, 1, 1, 3, 3, 2}, 3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] arr, int k, int expected) {
        // given
        LeastNumberOfUniqueIntegersAfterKRemovals solution = new LeastNumberOfUniqueIntegersAfterKRemovals();

        // when
        int result = solution.findLeastNumOfUniqueInts(arr, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}