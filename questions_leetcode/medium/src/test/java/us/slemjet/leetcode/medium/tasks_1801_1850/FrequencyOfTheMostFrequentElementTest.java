package us.slemjet.leetcode.medium.tasks_1801_1850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FrequencyOfTheMostFrequentElementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, 5, 3),
                Arguments.of(new int[]{1, 4, 8, 13}, 5, 2),
                Arguments.of(new int[]{3, 9, 6}, 2, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, int expected) {
        // given
        FrequencyOfTheMostFrequentElement solution = new FrequencyOfTheMostFrequentElement();

        // when
        int result = solution.maxFrequency(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBinarySearch(int[] nums, int k, int expected) {
        // given
        FrequencyOfTheMostFrequentElement solution = new FrequencyOfTheMostFrequentElement();

        // when
        int result = solution.maxFrequencyBinarySearch(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}