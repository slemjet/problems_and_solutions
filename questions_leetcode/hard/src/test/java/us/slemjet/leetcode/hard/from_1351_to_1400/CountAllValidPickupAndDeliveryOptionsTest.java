package us.slemjet.leetcode.hard.from_1351_to_1400;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountAllValidPickupAndDeliveryOptionsTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 6),
                Arguments.of(3, 90),
                Arguments.of(8, 729647433)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCountOrders(int n, int expected) {
        // given
        CountAllValidPickupAndDeliveryOptions solution = new CountAllValidPickupAndDeliveryOptions();

        // when
        int value = solution.countOrders(n);

        // then
        Assertions.assertThat(value).isEqualTo(expected);
    }
}