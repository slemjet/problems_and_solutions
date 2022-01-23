package us.slemjet.leetcode.medium.tasks_501_550;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_501_550.SingleElementInASortedArray;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class SingleElementInASortedArrayTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2),
                of(new int[]{3, 3, 7, 7, 10, 11, 11}, 10),
                of(new int[]{1, 1, 2, 2, 3}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void singleNonDuplicate(int[] nums, int expected) {
        // given
        SingleElementInASortedArray solution = new SingleElementInASortedArray();

        // when
        int result = solution.singleNonDuplicate(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
