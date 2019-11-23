package pl.slemjet.katas.nesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StoneWallTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(int[] H, int expected) {
        // when
        int result = StoneWall.solution(H);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
