package us.slemjet.leetcode.easy.tasks_1851_1900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RedistributeCharactersToMakeAllStringsEqualTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "aabc", "bc"}, true),
                Arguments.of(new String[]{"ab", "a"}, false),
                Arguments.of(new String[]{"a","b"}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionTopDown(String[] words, boolean expected) {
        // given
        RedistributeCharactersToMakeAllStringsEqual solution = new RedistributeCharactersToMakeAllStringsEqual();

        // when
        boolean result = solution.makeEqual(words);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}