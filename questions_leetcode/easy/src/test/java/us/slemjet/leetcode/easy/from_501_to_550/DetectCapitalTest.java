package us.slemjet.leetcode.easy.from_501_to_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DetectCapitalTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("USA", true),
                Arguments.of("FlaG", false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDetectCapitalUse(String word, boolean expected) {
        // given
        DetectCapital solution = new DetectCapital();

        // when
        boolean result = solution.detectCapitalUse(word);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}