package us.slemjet.leetcode.easy.tasks_2451_2500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindThePivotIntegerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(8, 6),
                Arguments.of(1, 1),
                Arguments.of(4, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        FindThePivotInteger solution = new FindThePivotInteger();

        // when
        int result = solution.pivotInteger(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}