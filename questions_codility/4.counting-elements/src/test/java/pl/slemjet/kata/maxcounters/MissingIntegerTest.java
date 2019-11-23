package pl.slemjet.kata.maxcounters;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MissingIntegerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
                Arguments.of(new int[]{1, 2, 3}, 4),
                Arguments.of(new int[]{-1, -3}, 1),
                Arguments.of(new int[]{2}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reverseTest(int[] array, int expected) {
        // when
        int result = MissingInteger.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
