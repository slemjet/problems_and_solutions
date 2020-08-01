package us.slemjet.leetcode.medium.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class FindAllAnagramsInAStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("cbaebabacd", "abc", Arrays.asList(0, 6)),
                of("abab", "ab", Arrays.asList(0, 1, 2)),
                of("aa", "bb", Collections.emptyList()),
                of("baa", "aa", Collections.singletonList(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findAnagrams(String s, String p, List<Integer> expected) {
        // given
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

        // when
        List<Integer> result = solution.findAnagrams(s, p);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findAnagramsArray(String s, String p, List<Integer> expected) {
        // given
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

        // when
        List<Integer> result = solution.findAnagramsArray(s, p);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
