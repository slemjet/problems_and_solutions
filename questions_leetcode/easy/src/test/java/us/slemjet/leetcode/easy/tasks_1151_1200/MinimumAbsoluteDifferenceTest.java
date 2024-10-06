package us.slemjet.leetcode.easy.tasks_1151_1200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MinimumAbsoluteDifferenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 1, 3}, List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4))),
                Arguments.of(new int[]{1, 3, 6, 10, 15}, List.of(List.of(1, 3))),
                Arguments.of(new int[]{3, 8, -10, 23, 19, -4, -14, 27}, List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27)))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] arr, List<List<Integer>> expected) {
        // given
        MinimumAbsoluteDifference solution = new MinimumAbsoluteDifference();

        // when
        List<List<Integer>> result = solution.minimumAbsDifference(arr);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}