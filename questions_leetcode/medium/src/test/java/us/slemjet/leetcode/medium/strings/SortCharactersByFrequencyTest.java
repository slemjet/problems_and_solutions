package us.slemjet.leetcode.medium.strings;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SortCharactersByFrequencyTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of("tree", "eert"),
                of("cccaaa", "cccaaa"),
                of("Aabb", "bbAa"),
                of("2a554442f544asfasssffffasss", "bbAa"),
                of("his s he a ha he  ha ae", "bbAa")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySort(String s, String expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySort(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySortMap(String s, String expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySortMap(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void frequencySortArr(String s, String expected) {
        // given
        SortCharactersByFrequency solution = new SortCharactersByFrequency();

        // when
        String result = solution.frequencySortArr(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
