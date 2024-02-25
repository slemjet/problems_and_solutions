package us.slemjet.leetcode.hard.tasks_2701_2750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GreatestCommonDivisorTraversalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 6}, true),
                Arguments.of(new int[]{3, 9, 5}, false),
                Arguments.of(new int[]{4, 3, 12, 8}, true),
                Arguments.of(new int[]{1}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBFS(int[] nums, boolean expected) {
        // given
        GreatestCommonDivisorTraversal solution = new GreatestCommonDivisorTraversal();

        // when
        boolean result = solution.canTraverseAllPairs(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}