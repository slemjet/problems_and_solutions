package us.slemjet.leetcode.medium.from_1_to_50;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ThreeSumClosestTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 1, -4}, 1, 2),
                Arguments.of(new int[]{0, 0, 0}, 1, 0),
                Arguments.of(new int[]{1, 1, 1, 1}, 0, 3),
                Arguments.of(new int[]{1, 1, -1, -1, 3}, -1, -1),
                Arguments.of(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82, 82)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void threeSumClosest(int[] nums, int target, int expected) {
        // given
        ThreeSumClosest solution = new ThreeSumClosest();

        // when
        int results = solution.threeSumClosest(nums, target);

        // then
        Assertions.assertThat(results).isEqualTo(expected);
    }
}
