package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_901_950.OnlineStockSpan;

import java.util.stream.Stream;

class OnlineStockSpanTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{100, 80, 60, 70, 60, 75, 85}, new int[]{1, 1, 1, 2, 1, 4, 6}),
                Arguments.of(new int[]{29, 91, 62, 76, 51}, new int[]{1, 2, 1, 2, 1}),
                Arguments.of(new int[]{28, 14, 28, 35, 46, 53, 66, 80, 87, 88}, new int[]{1, 1, 3, 4, 5, 6, 7, 8, 9, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void onlineStockSpan(int next[], int[] expected) {
        // given
        OnlineStockSpan.StockSpanner stockSpanner = new OnlineStockSpan.StockSpanner();

        // when
        for (int i = 0; i < next.length; i++) {
            int price = next[i];
            int expected1 = expected[i];
            Assertions.assertThat(stockSpanner.next(price)).isEqualTo(expected1);
        }
    }
}
