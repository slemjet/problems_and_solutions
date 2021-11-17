package us.slemjet.leetcode.easy.from_150_to_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_150_to_200.HouseRobber;

import java.util.stream.Stream;

class HouseRobberTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void rob(int[] nums, int expected) {
        // given
        HouseRobber solution = new HouseRobber();

        // when
        int robbed = solution.rob(nums);

        // then
        Assertions.assertThat(robbed).isEqualTo(expected);
    }
}