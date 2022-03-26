package us.slemjet.leetcode.easy.from_701_to_750;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinarySearchTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSearch(int[] nums, int target, int expected) {
        // given
        BinarySearch solution = new BinarySearch();

        // when
        int result = solution.search(nums, target);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}