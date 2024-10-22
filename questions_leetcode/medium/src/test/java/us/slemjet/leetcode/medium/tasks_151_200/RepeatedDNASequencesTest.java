package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedDNASequencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(

                Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC","CCCCCAAAAA")),
                Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA"))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsNumIslands(String s, List<String> expected) {
        // given
        RepeatedDNASequences solution = new RepeatedDNASequences();

        // when
        List<String> result = solution.findRepeatedDnaSequences(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}