package us.slemjet.leetcode.medium.tasks_1601_1650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LexicographicallySmallestStringAfterApplyingOperationsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5525", 9, 2, "2050"),
                Arguments.of("74", 5, 1, "24"),
                Arguments.of("0011", 4, 2, "0011")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String s, int a, int b, String expected) {
        // given
        LexicographicallySmallestStringAfterApplyingOperations solution = new LexicographicallySmallestStringAfterApplyingOperations();

        // when
        String result = solution.findLexSmallestString(s, a, b);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}