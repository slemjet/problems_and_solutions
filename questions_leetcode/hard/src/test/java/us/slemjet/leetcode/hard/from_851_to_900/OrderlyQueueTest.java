package us.slemjet.leetcode.hard.from_851_to_900;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OrderlyQueueTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("cba", 1, "acb"),
                Arguments.of("kuh", 1, "hku"),
                Arguments.of("baaca", 3, "aaabc")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testOrderlyQueue(String s, int k, String expected) {
        // given
        OrderlyQueue solution = new OrderlyQueue();

        // when
        String result = solution.orderlyQueue(s, k);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}