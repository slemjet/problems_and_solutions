package us.slemjet.leetcode.medium.tasks_201_250;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ProductOfArrayExceptSelfTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // [1,2,3,4] -> Output: [24,12,8,6]
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                // [-1,1,0,-3,3] -> Output: [0,0,9,0,0]
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testProductExceptSelf(int[] nums, int[] expected) {
        // given
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // when
        int[] result = solution.productExceptSelf(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}