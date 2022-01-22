package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class TriangleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3)), 11),
                Arguments.of(Arrays.asList(Arrays.asList(-10)), -10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinimumTotalBottomUp(List<List<Integer>> triangle, int expected) {
        // given
        Triangle solution = new Triangle();

        // when
        int result = solution.minimumTotalBottomUp(triangle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinimumTotalBottomUp2(List<List<Integer>> triangle, int expected) {
        // given
        Triangle solution = new Triangle();

        // when
        int result = solution.minimumTotalBottomUp2(triangle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinimumTotalTopToBottom(List<List<Integer>> triangle, int expected) {
        // given
        Triangle solution = new Triangle();

        // when
        int result = solution.minimumTotalTopToBottom(triangle);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}