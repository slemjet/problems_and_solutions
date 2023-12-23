package us.slemjet.leetcode.easy.from_1451_to_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PathCrossingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("NES", false),
                Arguments.of("NESWW", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String path, boolean expected) {
        // given
        PathCrossing solution = new PathCrossing();

        // when
        boolean result = solution.isPathCrossing(path);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}