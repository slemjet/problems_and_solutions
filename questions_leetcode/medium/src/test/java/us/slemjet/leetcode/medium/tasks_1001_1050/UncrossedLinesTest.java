package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_1001_1050.UncrossedLines;

import java.util.stream.Stream;

class UncrossedLinesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 2}, new int[]{1, 2, 4}, 2),
                Arguments.of(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}, 3),
                Arguments.of(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}, 2),
                Arguments.of(new int[]{1, 4, 2, 1, 2, 5}, new int[]{1, 2, 4, 3, 4, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxUncrossedLinesDpRec(int[] A, int[] B, int expected) {
        // given
        UncrossedLines solution = new UncrossedLines();

        // when
        int value = solution.maxUncrossedLinesDpRec(A, B);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxUncrossedLinesDpCycle(int[] A, int[] B, int expected) {
        // given
        UncrossedLines solution = new UncrossedLines();

        // when
        int value = solution.maxUncrossedLinesDpCycle(A, B);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void maxUncrossedLinesSimple(int[] A, int[] B, int expected) {
        // given
        UncrossedLines solution = new UncrossedLines();

        // when
        int value = solution.maxUncrossedLinesSimple(A, B);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}
