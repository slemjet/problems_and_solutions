package us.slemjet.leetcode.medium.tasks_101_150;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SingleNumberIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 3, 2}, 3),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 99}, 99),
                Arguments.of(new int[]{-401451, -177656, -2147483646, -473874, -814645, -2147483646, -852036, -457533, -401451, -473874, -401451, -216555, -917279, -457533, -852036, -457533, -177656, -2147483646, -177656, -917279, -473874, -852036, -917279, -216555, -814645, 2147483645, -2147483648, 2147483645, -814645, 2147483645, -216555}, -2147483648)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSingleNumber(int[] nums, int expected) {
        // given
        SingleNumberII solution = new SingleNumberII();

        // when
        int result = solution.singleNumber(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSingleNumberCount(int[] nums, int expected) {
        // given
        SingleNumberII solution = new SingleNumberII();

        // when
        int result = solution.singleNumberCountBits(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}