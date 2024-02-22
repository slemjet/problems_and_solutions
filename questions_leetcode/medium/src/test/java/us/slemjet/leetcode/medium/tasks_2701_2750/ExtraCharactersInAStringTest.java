package us.slemjet.leetcode.medium.tasks_2701_2750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ExtraCharactersInAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("leetscode", new String[]{"leet", "code", "leetcode"}, 1),
                Arguments.of("sayhelloworld", new String[]{"hello", "world"}, 3),
                Arguments.of("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopToBottom(String s, String[] dictionary, int expected) {
        // given
        ExtraCharactersInAString solution = new ExtraCharactersInAString();

        // when
        int result = solution.minExtraCharTopToBottom(s, dictionary);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBottomUp(String s, String[] dictionary, int expected) {
        // given
        ExtraCharactersInAString solution = new ExtraCharactersInAString();

        // when
        int result = solution.minExtraCharBottomUp(s, dictionary);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}