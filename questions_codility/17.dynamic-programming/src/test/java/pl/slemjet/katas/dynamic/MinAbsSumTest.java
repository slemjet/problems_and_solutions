package pl.slemjet.katas.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinAbsSumTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 2, -2}, 0),
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{3, 3, 3, 4, 5}, 0),
                Arguments.of(new int[]{-100, 3, 2, 4}, 91)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] input, int expected) {
        // when
        int result = MinAbsSum.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
