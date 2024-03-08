package us.slemjet.leetcode.easy.tasks_3001_3050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountElementsWithMaximumFrequencyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 1, 4}, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        CountElementsWithMaximumFrequency solution = new CountElementsWithMaximumFrequency();

        // when
        int result = solution.maxFrequencyElements(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}