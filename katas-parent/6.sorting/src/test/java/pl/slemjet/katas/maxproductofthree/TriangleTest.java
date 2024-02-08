package pl.slemjet.katas.maxproductofthree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TriangleTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{10, 2, 5, 1, 8, 20}, 1),
                Arguments.of(new int[]{10, 50, 5, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] array, int expected) {
        // when
        int result = Triangle.solution(array);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
