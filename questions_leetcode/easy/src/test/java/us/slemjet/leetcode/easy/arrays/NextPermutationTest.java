package us.slemjet.leetcode.easy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_0_to_50.NextPermutation;

import java.util.stream.Stream;

class NextPermutationTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 1, 5}, new int[]{1, 5, 1}),
                Arguments.of(new int[]{1, 3, 2}, new int[]{2, 1, 3}),
                Arguments.of(new int[]{2, 3, 1}, new int[]{3, 1, 2}),
                Arguments.of(new int[]{1, 5, 1}, new int[]{5, 1, 1}),
                Arguments.of(new int[]{5, 1, 1}, new int[]{1, 1, 5}),
                Arguments.of(new int[]{2, 1, 2, 2, 2, 2, 2, 1}, new int[]{2, 2, 1, 1, 2, 2, 2, 2}),
                Arguments.of(new int[]{2,3,1,3,3}, new int[]{2,3,3,1,3})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void nextPermutation(int[] nums, int[] expected) {
        // given
        NextPermutation solution = new NextPermutation();

        // when
        solution.nextPermutation(nums);

        // then
        Assertions.assertThat(nums).isEqualTo(expected);
    }
}
