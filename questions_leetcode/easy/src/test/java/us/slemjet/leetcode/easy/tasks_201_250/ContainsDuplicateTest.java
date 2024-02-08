package us.slemjet.leetcode.easy.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ContainsDuplicateTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testContainsDuplicate(int[] nums, boolean expected) {
        // given
        ContainsDuplicate solution = new ContainsDuplicate();

        // when
        boolean result = solution.containsDuplicate(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testContainsDuplicateSort(int[] nums, boolean expected) {
        // given
        ContainsDuplicate solution = new ContainsDuplicate();

        // when
        boolean result = solution.containsDuplicateSort(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}