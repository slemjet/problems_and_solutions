package pl.slemjet.katas.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSolitaireTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, -2, 0, 9, -1, -2}, 8),
                Arguments.of(new int[]{-2, 5, 1}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] input, int expected) {
        // when
        int result = NumberSolitaire.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
