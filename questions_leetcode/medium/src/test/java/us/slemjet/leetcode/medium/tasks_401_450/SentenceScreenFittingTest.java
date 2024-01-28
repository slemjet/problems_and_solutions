package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SentenceScreenFittingTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"hello", "world"}, 2, 8, 1),
                Arguments.of(new String[]{"a", "bcd", "e"}, 3, 6, 2),
                Arguments.of(new String[]{"i", "had", "apple", "pie"}, 4, 5, 1),
                Arguments.of(new String[]{"try","to","be","better"}, 10000, 9001, 5293333)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSimulation(String[] sentence, int rows, int cols, int expected) {
        // given
        SentenceScreenFitting solution = new SentenceScreenFitting();

        // when
        int result = solution.wordsTypingSimulation(sentence, rows, cols);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] sentence, int rows, int cols, int expected) {
        // given
        SentenceScreenFitting solution = new SentenceScreenFitting();

        // when
        int result = solution.wordsTyping(sentence, rows, cols);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}