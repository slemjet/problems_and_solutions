package us.slemjet.leetcode.easy.tasks_3201_3250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LexicographicallySmallestStringASwapTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("45320", "43520"),
                Arguments.of("001", "001")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String expected) {
        // given
        LexicographicallySmallestStringASwap solution = new LexicographicallySmallestStringASwap();

        // when
        String result = solution.getSmallestString(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}