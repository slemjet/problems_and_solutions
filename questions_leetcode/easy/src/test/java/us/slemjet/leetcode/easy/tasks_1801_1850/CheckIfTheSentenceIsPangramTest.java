package us.slemjet.leetcode.easy.tasks_1801_1850;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CheckIfTheSentenceIsPangramTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("thequickbrownfoxjumpsoverthelazydog", true),
                Arguments.of("leetcode", false),
                Arguments.of("anmt", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCheckIfPangram(String sentence, boolean expected) {
        // given
        CheckIfTheSentenceIsPangram solution = new CheckIfTheSentenceIsPangram();

        // when
        boolean result = solution.checkIfPangram(sentence);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}