package us.slemjet.leetcode.easy.from_2151_to_2200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KeepMultiplyingFoundValuesByTwoTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 6, 1, 12}, 3, 24),
                Arguments.of(new int[]{2, 7, 9}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int original, int expected) {
        // given
        KeepMultiplyingFoundValuesByTwo solution = new KeepMultiplyingFoundValuesByTwo();

        // when
        int result = solution.findFinalValue(nums, original);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}