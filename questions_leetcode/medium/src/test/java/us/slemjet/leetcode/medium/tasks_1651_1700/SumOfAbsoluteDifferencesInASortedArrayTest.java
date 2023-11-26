package us.slemjet.leetcode.medium.tasks_1651_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumOfAbsoluteDifferencesInASortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 5}, new int[]{4, 3, 5}),
                Arguments.of(new int[]{1, 4, 6, 8, 10}, new int[]{24, 15, 13, 15, 21})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] expected) {
        // given
        SumOfAbsoluteDifferencesInASortedArray solution = new SumOfAbsoluteDifferencesInASortedArray();

        // when
        int[] result = solution.getSumAbsoluteDifferences(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}