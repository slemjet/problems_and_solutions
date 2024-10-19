package us.slemjet.leetcode.medium.tasks_2251_2300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindResultantArrayAfterRemovingAnagramsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"abba", "baba", "bbaa", "cd", "cd"}, List.of("abba", "cd")),
                Arguments.of(new String[]{"a", "b", "c", "d", "e"}, List.of("a", "b", "c", "d", "e"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] words, List<String> expected) {
        // given
        FindResultantArrayAfterRemovingAnagrams solution = new FindResultantArrayAfterRemovingAnagrams();

        // when
        List<String> result = solution.removeAnagrams(words);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}