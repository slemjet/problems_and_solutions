package us.slemjet.leetcode.easy.tasks_601_650;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SetMismatchTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 4}, new int[]{2, 3}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 2}, new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int[] expected) {
        // given
        SetMismatch solution = new SetMismatch();

        // when
        int[] result = solution.findErrorNums(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}