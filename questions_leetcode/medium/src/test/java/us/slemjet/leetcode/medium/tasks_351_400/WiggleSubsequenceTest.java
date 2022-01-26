package us.slemjet.leetcode.medium.tasks_351_400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WiggleSubsequenceTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 7, 4, 9, 2, 5}, 6),
                Arguments.of(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testWiggleMaxLength(int[] nums, int expected) {
        // given
        WiggleSubsequence solution = new WiggleSubsequence();

        // when
        int result = solution.wiggleMaxLength(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}