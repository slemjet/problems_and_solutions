package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class GroupAnagramsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, Lists.newArrayList(
                        Lists.newArrayList("bat"),
                        Lists.newArrayList("tan", "nat"),
                        Lists.newArrayList("eat", "tea", "ate")
                )),
                Arguments.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"}, Lists.newArrayList(
                        Lists.newArrayList("bdd"),
                        Lists.newArrayList("bbdd"),
                        Lists.newArrayList("eat", "tea", "ate"),
                        Lists.newArrayList("acc"),
                        Lists.newArrayList("tan", "nat"),
                        Lists.newArrayList("aacc"),
                        Lists.newArrayList("bat"),
                        Lists.newArrayList("ac"),
                        Lists.newArrayList("bd"),
                        Lists.newArrayList("aac"),
                        Lists.newArrayList("bbd")
                )),
                Arguments.of(new String[]{""}, Arrays.asList(Arrays.asList(""))),
                Arguments.of(new String[]{"a"}, Arrays.asList(Arrays.asList("a")))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void groupAnagrams(String[] strs, List<List<String>> expected) {
        // given
        GroupAnagrams solution = new GroupAnagrams();

        // when
        List<List<String>> result = solution.groupAnagrams(strs);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void groupAnagramsList(String[] strs, List<List<String>> expected) {
        // given
        GroupAnagrams solution = new GroupAnagrams();

        // when
        List<List<String>> result = solution.groupAnagramsList(strs);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void groupAnagramsList2(String[] strs, List<List<String>> expected) {
        // given
        GroupAnagrams solution = new GroupAnagrams();

        // when
        List<List<String>> result = solution.groupAnagramsList2(strs);

        // then
        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }
}
