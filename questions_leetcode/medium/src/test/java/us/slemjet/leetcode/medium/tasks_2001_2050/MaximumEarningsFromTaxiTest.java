package us.slemjet.leetcode.medium.tasks_2001_2050;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaximumEarningsFromTaxiTest {

    private Stream<Arguments> parameters() throws IOException {

        return Stream.of(
                Arguments.of(5, new int[][]{new int[]{2, 5, 4}, new int[]{1, 5, 1}}, 7),
                Arguments.of(20, new int[][]{new int[]{1, 6, 1}, new int[]{3, 10, 2}, new int[]{10, 12, 3},
                        new int[]{11, 12, 2}, new int[]{12, 15, 2}, new int[]{13, 18, 1}}, 20),
                Arguments.of(25, new int[][]{new int[]{1, 6, 1}, new int[]{3, 10, 2}, new int[]{10, 12, 3},
                        new int[]{11, 12, 2}, new int[]{12, 15, 2}, new int[]{13, 18, 1}, new int[]{19, 23, 3}}, 27),
                Arguments.of(90000,
                        new ObjectMapper().readValue(
                                getClass().getClassLoader().getResourceAsStream("data/MaximumEarningsFromTaxiTest.json"), int[][].class),
                        2331223312L)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaxTaxiEarningsDp(int n, int[][] rides, long expected) {
        // given
        MaximumEarningsFromTaxi solution = new MaximumEarningsFromTaxi();

        // when
        long result = solution.maxTaxiEarningsDp(n, rides);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}