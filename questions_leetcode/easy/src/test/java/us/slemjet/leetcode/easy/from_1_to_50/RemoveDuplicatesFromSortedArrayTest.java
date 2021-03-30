package us.slemjet.leetcode.easy.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RemoveDuplicatesFromSortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void removeDuplicates(int[] input, int expected) {
        // given
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();

        // when
        int result = solution.removeDuplicates(input);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
