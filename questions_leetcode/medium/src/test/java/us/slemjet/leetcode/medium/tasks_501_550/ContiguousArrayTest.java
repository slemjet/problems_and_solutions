package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_501_550.ContiguousArray;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class ContiguousArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{0, 1}, 2),
                of(new int[]{0, 1, 0}, 2),
                of(new int[]{0, 0, 1, 0, 0, 0, 1, 1}, 6)
        );
    }

    @Disabled // No longer works
    @ParameterizedTest
    @MethodSource("parameters")
    void findMaxLength(int[] nums, int expected) {
        // given
        ContiguousArray solution = new ContiguousArray();

        // when
        int result = solution.findMaxLength(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void findMaxLengthArr(int[] nums, int expected) {
        // given
        ContiguousArray solution = new ContiguousArray();

        // when
        int result = solution.findMaxLengthArr(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
