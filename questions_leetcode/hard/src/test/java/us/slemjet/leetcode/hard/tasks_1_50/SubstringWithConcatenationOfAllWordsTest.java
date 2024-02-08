package us.slemjet.leetcode.hard.tasks_1_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class SubstringWithConcatenationOfAllWordsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("barfoothefoobarman", new String[]{"foo", "bar"}, Arrays.asList(0, 9)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}, new ArrayList<>()),
                Arguments.of("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}, Arrays.asList(6, 9, 12)),
                Arguments.of("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}, Collections.singletonList(8))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindSubstring(String s, String[] words, List<Integer> expected) {
        // given
        SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();

        // when
        List<Integer> indices = solution.findSubstring(s, words);

        // then
        Assertions.assertThat(indices).containsExactlyInAnyOrderElementsOf(expected);
    }
}