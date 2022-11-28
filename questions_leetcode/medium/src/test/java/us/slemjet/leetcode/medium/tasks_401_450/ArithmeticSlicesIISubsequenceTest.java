package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArithmeticSlicesIISubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 6, 8, 10}, 7),
                Arguments.of(new int[]{7, 7, 7, 7, 7}, 16),
                Arguments.of(new int[]{0, 2000000000, -294967296}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testNumberOfArithmeticSlices(int[] nums, int expected) {
        // given
        ArithmeticSlicesIISubsequence solution = new ArithmeticSlicesIISubsequence();

        // when
        int result = solution.numberOfArithmeticSlices(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}