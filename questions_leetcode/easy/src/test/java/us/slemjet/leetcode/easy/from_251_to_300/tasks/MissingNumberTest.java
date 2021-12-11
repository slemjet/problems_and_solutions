package us.slemjet.leetcode.easy.from_251_to_300.tasks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_251_to_300.MissingNumber;

import java.util.stream.Stream;

class MissingNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1}, 2),
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8),
                Arguments.of(new int[]{0}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMissingNumber(int[] nums, int expected) {
        // given
        MissingNumber solution = new MissingNumber();

        // when
        int result = solution.missingNumber(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}