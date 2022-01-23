package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_451_500.SortCharactersByFrequency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SortCharactersByFrequencyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("tree", Arrays.asList("eert")),
                of("cccaaa", Arrays.asList("aaaccc")),
                of("Aabb", Arrays.asList("bbaA", "bbAa")),
                of("2a554442f544asfasssffffasss", Arrays.asList("sssssssffffff44444aaaa55522")),
                of("his s he a ha he  ha ae", Arrays.asList("        hhhhhaaaaeeessi"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySort(String s, List<String> expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySort(s);

        // then
        Assertions.assertThat(expected).containsAnyOf(result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySortMap(String s, List<String> expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySortMap(s);

        // then
        Assertions.assertThat(expected).containsAnyOf(result);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySortArr(String s, List<String> expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySortArr(s);

        // then
        Assertions.assertThat(expected).containsAnyOf(result);
    }
}
