package us.slemjet.leetcode.medium.tasks_251_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FindTheDuplicateNumberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.of(new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.of(new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 1, 2}, 1),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 2),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 2),
                Arguments.of(new int[]{8, 1, 1, 1, 2, 7, 4, 3, 1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicate(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicate(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicateBit(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicateBit(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicateBinary(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicateBinary(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicateNegative(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicateNegative(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicateSet(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicateSet(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindDuplicateSort(int[] nums, int expected) {
        // given
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();

        // when
        int result = solution.findDuplicateSort(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}