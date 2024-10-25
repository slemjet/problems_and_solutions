package us.slemjet.leetcode.easy.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DegreeOfAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 1}, 2),
                Arguments.of(new int[]{1, 2, 2, 3, 1, 4, 2}, 6),
                Arguments.of(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int expected) {
        // given
        DegreeOfAnArray solution = new DegreeOfAnArray();

        // when
        int result = solution.findShortestSubArray(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}