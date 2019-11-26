package com.slemjet.questions.other;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsFinderTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("BA", new HashSet<>(Arrays.asList("BA", "AB"))),
                Arguments.of("BEEF", new HashSet<>(Arrays.asList("FEBE", "EEBF", "EFBE", "BEEF", "BFEE", "EBFE", "EEFB", "FBEE", "FEEB", "BEFE", "EBEF", "EFEB"))),
                Arguments.of("BEE", new HashSet<>(Arrays.asList("BEE", "EEB", "EBE")))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void solutionTest(String input, Set<String> expected) {
        // when
        Set<String> result = PermutationsFinder.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
