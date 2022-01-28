package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DesignAddAndSearchWordsDataStructureTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"},
                        new String[]{null, "bad", "dad", "mad", "pad", "bad", ".ad", "b.."},
                        new Boolean[]{null, null, null, null, false, true, true, true}),
                Arguments.of(new String[]{
                                        "WordDictionary",   "addWord",  "addWord",  "search",   "search",   "search",   "search",   "search",   "search"},
                        new String[]{   null,               "a",        "a",        ".",        "a",        "aa",       "a",        ".a",       "a."},
                        new Boolean[]{  null,               null,       null,       true,       true,       false,      true,       false,      false})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWordDictionary(String[] commands, String[] params, Boolean[] expected) {
        DesignAddAndSearchWordsDataStructure.WordDictionary wordDictionary = null;

        for (int i = 0; i < commands.length; i++) {
            if ("WordDictionary".equals(commands[i]))
                wordDictionary = new DesignAddAndSearchWordsDataStructure.WordDictionary();
            else if ("addWord".equals(commands[i]))
                wordDictionary.addWord(params[i]);
            else if ("search".equals(commands[i]))
                Assertions.assertThat(wordDictionary.search(params[i])).isEqualTo(expected[i]);
        }
    }
}