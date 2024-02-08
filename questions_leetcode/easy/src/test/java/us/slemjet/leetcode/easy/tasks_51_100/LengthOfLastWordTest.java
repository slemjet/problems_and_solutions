package us.slemjet.leetcode.easy.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LengthOfLastWordTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int expected) {
        // given
        LengthOfLastWord solution = new LengthOfLastWord();

        // when
        int result = solution.lengthOfLastWord(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}