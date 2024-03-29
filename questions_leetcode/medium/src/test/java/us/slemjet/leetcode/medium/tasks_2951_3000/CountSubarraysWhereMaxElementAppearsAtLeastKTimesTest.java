package us.slemjet.leetcode.medium.tasks_2951_3000;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class CountSubarraysWhereMaxElementAppearsAtLeastKTimesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{1, 3, 2, 3, 3}, 2, 6),
                of(new int[]{1, 4, 2, 1}, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] nums, int k, long expected) {
        // given
        CountSubarraysWhereMaxElementAppearsAtLeastKTimes solution = new CountSubarraysWhereMaxElementAppearsAtLeastKTimes();

        // when
        long result = solution.countSubarrays(nums, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}