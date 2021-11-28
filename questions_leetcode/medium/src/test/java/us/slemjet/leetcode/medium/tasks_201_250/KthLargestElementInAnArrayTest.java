package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class KthLargestElementInAnArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, 2, 1),
                Arguments.of(new int[]{1}, 1, 1),
                Arguments.of(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindKthLargest(int[] nums, int k, int expected) {
        // given
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();

        // when
        int value = solution.findKthLargest(nums, k);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}