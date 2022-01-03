package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TopKFrequentElementsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{-1, -1}, 1, new int[]{-1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{1, 2})
        );
    }

    private static Stream<Arguments> parameters2() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{2, 1}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{-1, -1}, 1, new int[]{-1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{1, 2})
        );
    }

    private static Stream<Arguments> parameters3() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{2, 1}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{-1, -1}, 1, new int[]{-1}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testTopKFrequent(int[] nums, int k, int[] expected) {
        // given
        TopKFrequentElements solution = new TopKFrequentElements();

        // when
        int[] result = solution.topKFrequent(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters2")
    void testTopKFrequentQSelect(int[] nums, int k, int[] expected) {
        // given
        TopKFrequentElements solution = new TopKFrequentElements();

        // when
        int[] result = solution.topKFrequentQSelect(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters3")
    void testTopKFrequentPriorityQueue(int[] nums, int k, int[] expected) {
        // given
        TopKFrequentElements solution = new TopKFrequentElements();

        // when
        int[] result = solution.topKFrequentPriorityQueue(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}