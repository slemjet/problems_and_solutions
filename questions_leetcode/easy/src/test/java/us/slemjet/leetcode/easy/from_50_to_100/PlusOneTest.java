package us.slemjet.leetcode.easy.from_50_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PlusOneTest {
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{0}, new int[]{1}),
                Arguments.of(new int[]{9}, new int[]{1, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void plusOne(int[] digits, int[] expected) {
        // given
        PlusOne solution = new PlusOne();

        // when
        int[] result = solution.plusOne(digits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
