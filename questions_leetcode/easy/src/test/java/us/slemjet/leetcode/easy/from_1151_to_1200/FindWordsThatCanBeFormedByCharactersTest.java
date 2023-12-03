package us.slemjet.leetcode.easy.from_1151_to_1200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindWordsThatCanBeFormedByCharactersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"cat", "bt", "hat", "tree"}, "atach", 6),
                Arguments.of(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] words, String chars, int expected) {
        // given
        FindWordsThatCanBeFormedByCharacters solution = new FindWordsThatCanBeFormedByCharacters();

        // when
        int result = solution.countCharacters(words, chars);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}