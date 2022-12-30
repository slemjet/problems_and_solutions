package us.slemjet.leetcode.easy.from_1701_to_1750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DetermineIfStringHalvesAreAlikeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("book", true),
                Arguments.of("textbook", false),
                Arguments.of("AbCdEfGh", true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testHalvesAreAlike(String s, boolean expected) {
        // given
        DetermineIfStringHalvesAreAlike solution = new DetermineIfStringHalvesAreAlike();

        // when
        boolean result = solution.halvesAreAlike(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}