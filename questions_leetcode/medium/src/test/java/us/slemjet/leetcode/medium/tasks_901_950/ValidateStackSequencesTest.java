package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ValidateStackSequencesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testValidateStackSequences(int[] pushed, int[] popped, boolean expected) {
        // given
        ValidateStackSequences solution = new ValidateStackSequences();

        // when
        boolean result = solution.validateStackSequences(pushed, popped);

        // then
        Assertions.assertThat(result).isIn(expected);
    }
}