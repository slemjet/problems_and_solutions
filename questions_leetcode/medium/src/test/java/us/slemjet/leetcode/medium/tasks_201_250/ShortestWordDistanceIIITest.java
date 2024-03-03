package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ShortestWordDistanceIIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding", 1),
                Arguments.of(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] wordsDict, String word1, String word2, int expected) {
        // given
        ShortestWordDistanceIII solution = new ShortestWordDistanceIII();

        // when
        int result = solution.shortestWordDistance(wordsDict, word1, word2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}