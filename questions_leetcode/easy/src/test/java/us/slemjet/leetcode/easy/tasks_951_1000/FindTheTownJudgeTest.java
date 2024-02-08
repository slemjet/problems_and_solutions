package us.slemjet.leetcode.easy.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_951_1000.FindTheTownJudge;

import java.util.stream.Stream;

class FindTheTownJudgeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, new int[][]{}, 1),
                Arguments.of(2, new int[][]{new int[]{1, 2}}, 2),
                Arguments.of(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}, 3),
                Arguments.of(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 1}}, -1),
                Arguments.of(3, new int[][]{new int[]{1, 2}, new int[]{2, 3}}, -1),
                Arguments.of(4, new int[][]{new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 3}, new int[]{2, 4}, new int[]{4, 3}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findJudge(int N, int[][] trust, int expected) {
        // given
        FindTheTownJudge solution = new FindTheTownJudge();

        // when
        int result = solution.findJudge(N, trust);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
