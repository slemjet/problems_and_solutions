package pl.slemjet.katas.nesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BracketsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("{[()()]}", 1),
                Arguments.of("([)()]", 0),
                Arguments.of("{{{{", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(String input, int expected) {
        // when
        int result = Brackets.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
