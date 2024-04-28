package us.slemjet.leetcode.hard.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FreedomTrailTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("godding", "gd", 4),
                Arguments.of("godding", "godding", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String ring, String key, int expected) {
        // given
        FreedomTrail solution = new FreedomTrail();

        // when
        int result = solution.findRotateSteps(ring, key);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}