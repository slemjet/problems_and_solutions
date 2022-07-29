package us.slemjet.leetcode.medium.tasks_851_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindAndReplacePatternTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb", List.of("mee", "aqq")),
                Arguments.of(new String[]{"a", "b", "c"}, "a", List.of("a", "b", "c"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindAndReplacePattern(String[] words, String pattern, List<String> expected) {
        // given
        FindAndReplacePattern solution = new FindAndReplacePattern();

        // when
        List<String> result = solution.findAndReplacePattern(words, pattern);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}