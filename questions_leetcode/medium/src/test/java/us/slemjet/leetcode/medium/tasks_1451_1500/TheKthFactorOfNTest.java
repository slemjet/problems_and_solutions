package us.slemjet.leetcode.medium.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class TheKthFactorOfNTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(12, 3, 3),
                of(7, 2, 7),
                of(4, 4, -1),
                of(1, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testKthFactor(int n, int k, int expected) {
        // given
        TheKthFactorOfN solution = new TheKthFactorOfN();

        // when
        int result = solution.kthFactor(n, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}