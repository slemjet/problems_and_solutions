package us.slemjet.leetcode.easy.tasks_3351_3400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ButtonWithLongestPushTimeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 2}, new int[]{2, 5}, new int[]{3, 9}, new int[]{1, 15}}, 1),
                Arguments.of(new int[][]{new int[]{10, 5}, new int[]{1, 7}}, 10),
                Arguments.of(new int[][]{new int[]{9, 4}, new int[]{19, 5}, new int[]{2, 8}, new int[]{3, 11}, new int[]{2, 15}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[][] events, int expected) {
        // given
        ButtonWithLongestPushTime solution = new ButtonWithLongestPushTime();

        // when
        int result = solution.buttonWithLongestTime(events);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}