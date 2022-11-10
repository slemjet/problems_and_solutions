package us.slemjet.leetcode.easy.from_1001_to_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveAllAdjacentDuplicatesInStringTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("abbaca", "ca"),
                Arguments.of("azxxzy", "ay")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testRemoveDuplicates(String s, String expected) {
        // given
        RemoveAllAdjacentDuplicatesInString solution = new RemoveAllAdjacentDuplicatesInString();

        // when
        String result = solution.removeDuplicates(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}