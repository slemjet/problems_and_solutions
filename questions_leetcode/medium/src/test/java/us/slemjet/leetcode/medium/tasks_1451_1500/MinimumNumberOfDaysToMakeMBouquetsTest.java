package us.slemjet.leetcode.medium.tasks_1451_1500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MinimumNumberOfDaysToMakeMBouquetsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 10, 3, 10, 2}, 3, 1, 3),
                Arguments.of(new int[]{1, 10, 3, 10, 2}, 3, 2, -1),
                Arguments.of(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3, 12),
                Arguments.of(new int[]{62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85}, 2, 7, 98)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMinDays(int[] bloomDay, int m, int k, int expected) {
        // given
        MinimumNumberOfDaysToMakeMBouquets solution = new MinimumNumberOfDaysToMakeMBouquets();

        // when
        int result = solution.minDays(bloomDay, m, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}