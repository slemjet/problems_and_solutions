package us.slemjet.leetcode.easy.from_351_to_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindTheDifferenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abcd", "abcde", 'e'),
                Arguments.of("", "y", 'y'));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindTheDifference(String s, String t, char expected) {
        // given
        FindTheDifference solution = new FindTheDifference();

        // when
        char result = solution.findTheDifference(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindTheDifferenceSums(String s, String t, char expected) {
        // given
        FindTheDifference solution = new FindTheDifference();

        // when
        char result = solution.findTheDifferenceSums(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}