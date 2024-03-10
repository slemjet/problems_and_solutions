package us.slemjet.leetcode.easy.tasks_2501_2550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_2501_2550.MinimumCommonValue;

import java.util.stream.Stream;

class MinimumCommonValueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums1, int[] nums2, int expected) {
        // given
        MinimumCommonValue solution = new MinimumCommonValue();

        // when
        int result = solution.getCommon(nums1, nums2);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}