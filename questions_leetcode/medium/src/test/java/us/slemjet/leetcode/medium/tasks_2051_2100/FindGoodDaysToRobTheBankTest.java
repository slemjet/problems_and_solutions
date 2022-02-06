package us.slemjet.leetcode.medium.tasks_2051_2100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class FindGoodDaysToRobTheBankTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 3, 3, 5, 6, 2}, 2, List.of(2, 3)),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 0, List.of(0, 1, 2, 3, 4)),
                Arguments.of(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2, List.of(5, 10, 14)),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 2, new ArrayList<Integer>()));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testGoodDaysToRobBank(int[] security, int time, List<Integer> expected) {
        // given
        FindGoodDaysToRobTheBank solution = new FindGoodDaysToRobTheBank();

        // when
        List<Integer> result = solution.goodDaysToRobBank(security, time);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}