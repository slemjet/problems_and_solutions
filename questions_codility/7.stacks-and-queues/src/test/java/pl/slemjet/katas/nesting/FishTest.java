package pl.slemjet.katas.nesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FishTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] A, int[] B, int expected) {
        // when
        int result = Fish.solution(A, B);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
