package pl.slemjet.codility.prefixsums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PassingCarsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 1, 1}, 5),
                Arguments.of(new int[]{0, 0, 0, 0, 1}, 4),
                Arguments.of(new int[]{1, 0, 1, 0, 0}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = PassingCars.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
