package us.slemjet.leetcode.easy.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveElementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void removeElement(int[] input, int val, int expected) {
        // given
        RemoveElement solution = new RemoveElement();

        // when
        int result = solution.removeElement(input, val);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
