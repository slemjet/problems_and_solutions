package us.slemjet.leetcode.medium.tasks_2101_2050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NumberOfLaserBeamsInABankTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"011001", "000000", "010100", "001000"}, 8),
                Arguments.of(new String[]{"000", "111", "000"}, 0),
                Arguments.of(new String[]{"1","1"}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] bank, int expected) {
        // given
        NumberOfLaserBeamsInABank solution = new NumberOfLaserBeamsInABank();

        // when
        int result = solution.numberOfBeams(bank);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}