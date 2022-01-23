package us.slemjet.leetcode.hard.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_50_to_100.EditDistance;

import java.util.stream.Stream;

class EditDistanceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("horse", "ros", 3),
                Arguments.of("intention", "execution", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String word1, String word2, int expected) {
        // given
        EditDistance solution = new EditDistance();

        // when
        int value = solution.minDistance(word1, word2);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionRecursion(String word1, String word2, int expected) {
        // given
        EditDistance solution = new EditDistance();

        // when
        int value = solution.minDistanceRecursion(word1, word2);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }

}
