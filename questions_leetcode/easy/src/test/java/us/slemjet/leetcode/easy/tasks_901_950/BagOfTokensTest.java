package us.slemjet.leetcode.easy.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BagOfTokensTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{100}, 50, 0),
                Arguments.of(new int[]{200, 100}, 150, 1),
                Arguments.of(new int[]{100, 200, 300, 400}, 200, 2),
                Arguments.of(new int[]{25}, 51, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] tokens, int power, int expected) {
        // given
        BagOfTokens solution = new BagOfTokens();

        // when
        int result = solution.bagOfTokensScore(tokens, power);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}