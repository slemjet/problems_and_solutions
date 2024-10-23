package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ReconstructOriginalDigitsFromEnglishTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("owoztneoer", "012"),
                Arguments.of("fviefuro", "45")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, String expected) {
        // given
        ReconstructOriginalDigitsFromEnglish solution = new ReconstructOriginalDigitsFromEnglish();

        // when
        String result = solution.originalDigits(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}