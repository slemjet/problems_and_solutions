package us.slemjet.leetcode.easy.from_101_to_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SingleNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
                Arguments.of(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsSingleNumber(int[] nums, int expected) {
        // given
        SingleNumber solution = new SingleNumber();

        // when
        int result = solution.singleNumber(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
