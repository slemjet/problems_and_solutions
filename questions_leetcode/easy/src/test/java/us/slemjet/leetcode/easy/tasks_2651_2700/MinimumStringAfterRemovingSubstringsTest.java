package us.slemjet.leetcode.easy.tasks_2651_2700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumStringAfterRemovingSubstringsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("ABFCACDB", 2),
                Arguments.of("ACBBD", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        MinimumStringAfterRemovingSubstrings solution = new MinimumStringAfterRemovingSubstrings();

        // when
        long result = solution.minLength(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}