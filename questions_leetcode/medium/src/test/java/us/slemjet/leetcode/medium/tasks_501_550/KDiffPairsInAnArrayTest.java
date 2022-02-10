package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KDiffPairsInAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 4, 1, 5}, 2, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 4),
                Arguments.of(new int[]{1, 3, 1, 5, 4}, 0, 1),
                Arguments.of(new int[]{-1, -2, -3}, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindPairsBinary(int[] nums, int k, int expected) {
        // given
        KDiffPairsInAnArray solution = new KDiffPairsInAnArray();

        // when
        int result = solution.findPairsBinary(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindPairs2Pointers(int[] nums, int k, int expected) {
        // given
        KDiffPairsInAnArray solution = new KDiffPairsInAnArray();

        // when
        int result = solution.findPairs2Pointers(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindPairs(int[] nums, int k, int expected) {
        // given
        KDiffPairsInAnArray solution = new KDiffPairsInAnArray();

        // when
        int result = solution.findPairs(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}