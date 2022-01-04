package us.slemjet.leetcode.medium.tasks_301_350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_301_350.CountingBits;

import java.util.stream.Stream;

class CountingBitsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new int[]{0, 1, 1}),
                Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void countBitsTest(int num, int[] expected) {
        // given
        CountingBits solution = new CountingBits();

        // when
        int[] result = solution.countBits(num);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
