package us.slemjet.leetcode.easy.from_1651_to_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_1651_to_1700.RichestCustomerWealth;

import java.util.stream.Stream;

class RichestCustomerWealthTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{3, 2, 1}}, 6),
                Arguments.of(new int[][]{
                        new int[]{1, 5},
                        new int[]{7, 3},
                        new int[]{3, 5}}, 10),
                Arguments.of(new int[][]{
                        new int[]{2, 8, 7},
                        new int[]{7, 1, 3},
                        new int[]{1, 9, 5}}, 17)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximumWealth(int[][] accounts, int expected) {
        // given
        RichestCustomerWealth solution = new RichestCustomerWealth();

        // when
        int result = solution.maximumWealth(accounts);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}