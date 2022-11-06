package us.slemjet.leetcode.easy.from_1001_to_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DivisorGameTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testDivisorGame(int n, boolean expected) {
        // given
        DivisorGame solution = new DivisorGame();

        // when
        boolean result = solution.divisorGame(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}