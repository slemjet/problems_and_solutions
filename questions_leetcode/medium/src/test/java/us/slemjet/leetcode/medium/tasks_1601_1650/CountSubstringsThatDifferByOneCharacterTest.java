package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountSubstringsThatDifferByOneCharacterTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aba", "baba", 6),
                Arguments.of("ab", "bb", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountSubstringsDp(String s, String t, int expected) {
        // given
        CountSubstringsThatDifferByOneCharacter solution = new CountSubstringsThatDifferByOneCharacter();

        // when
        int result = solution.countSubstringsDp(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountSubstrings(String s, String t, int expected) {
        // given
        CountSubstringsThatDifferByOneCharacter solution = new CountSubstringsThatDifferByOneCharacter();

        // when
        int result = solution.countSubstrings(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}