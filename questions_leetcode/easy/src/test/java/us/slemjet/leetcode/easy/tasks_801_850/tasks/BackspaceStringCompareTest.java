package us.slemjet.leetcode.easy.tasks_801_850.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_801_850.BackspaceStringCompare;

import java.util.stream.Stream;

class BackspaceStringCompareTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("ab#c", "ad#c", true),
                Arguments.of("ab##", "c#d#", true),
                Arguments.of("a#c", "b", false),
                Arguments.of("a##c", "#a#c", true),  // Both become "c"
                Arguments.of("", "", true),  // Both are empty strings
                Arguments.of("#", "", true),  // "#" results in an empty string
                Arguments.of("a#b#c#", "", true),  // "a#b#c#" results in an empty string
                Arguments.of("a#b#c#", "d#d#", true),  // Both result in an empty string
                Arguments.of("###", "", true),  // Multiple backspaces on an empty string are still empty strings
                Arguments.of("ab#c", "ad#c##", false),  // Different lengths after backspaces
                Arguments.of("#a#bc#c", "bc", true),  // Both become "bc"
                Arguments.of("bxj##tw", "bxo#j##tw", true)  // Both become "btw"
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testBackspaceCompare(String s, String t, boolean expected) {
        // given
        var solution = new BackspaceStringCompare();

        // when
        boolean result = solution.backspaceCompare(s, t);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}