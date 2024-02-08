package us.slemjet.leetcode.easy.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AssignCookiesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] g, int[] s, int expected) {
        // given
        AssignCookies solution = new AssignCookies();

        // when
        int result = solution.findContentChildren(g, s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}