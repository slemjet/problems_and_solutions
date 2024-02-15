package us.slemjet.leetcode.medium.tasks_951_1000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KnightDialerTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 10),
                Arguments.of(2, 20),
                Arguments.of(3131, 136006598)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        KnightDialer solution = new KnightDialer();

        // when
        int result = solution.knightDialer(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}