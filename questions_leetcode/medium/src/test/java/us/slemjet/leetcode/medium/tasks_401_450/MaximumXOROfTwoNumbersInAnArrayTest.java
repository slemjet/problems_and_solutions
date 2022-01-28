package us.slemjet.leetcode.medium.tasks_401_450;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MaximumXOROfTwoNumbersInAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 10, 5, 25, 2, 8}, 28),
                Arguments.of(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindMaximumXOR(int[] nums, int expected) {
        // given
        MaximumXOROfTwoNumbersInAnArray solution = new MaximumXOROfTwoNumbersInAnArray();

        // when
        int value = solution.findMaximumXOR(nums);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}