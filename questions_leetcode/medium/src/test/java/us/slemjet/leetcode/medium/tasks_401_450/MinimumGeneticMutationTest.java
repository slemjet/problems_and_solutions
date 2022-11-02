package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumGeneticMutationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}, 1),
                Arguments.of("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}, 2),
                Arguments.of("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}, 3),
                Arguments.of("AAAACCCC", "CCCCCCCC", new String[]{"AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC"}, 4),
                Arguments.of("AACCGGTT", "AACCGGTA", new String[0], -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinMutation(String start, String end, String[] bank, int expected) {
        // given
        MinimumGeneticMutation solution = new MinimumGeneticMutation();

        // when
        int result = solution.minMutation(start, end, bank);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}