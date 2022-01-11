package us.slemjet.leetcode.medium.tasks_151_200;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_151_200.FindPeakElement;

import java.util.stream.Stream;

class FindPeakElementTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 2),
                Arguments.of(new int[]{1, 2, 1, 3, 5, 6, 4}, 5),
                Arguments.of(new int[]{2, 1}, 0),
                Arguments.of(new int[]{1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testsFindPeakElement(int[] nums, int expected) {
        // given
        FindPeakElement solution = new FindPeakElement();

        // when
        int result = solution.findPeakElement(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}