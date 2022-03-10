package us.slemjet.leetcode.medium.tasks_1001_1050;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CorporateFlightBookingsTest {

    public static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5 -> Output: [10,55,45,25,25]
                Arguments.of(new int[][]{new int[]{1, 2, 10}, new int[]{2, 3, 20}, new int[]{2, 5, 25}}, 5, new int[]{10, 55, 45, 25, 25}),
                // Input: bookings = [[1,2,10],[2,2,15]], n = 2 -> Output: [10,25]
                Arguments.of(new int[][]{new int[]{1, 2, 10}, new int[]{2, 2, 15}}, 2, new int[]{10, 25}),
                // Input: bookings = [[1,3,20],[4,4,10],[1,2,50],[2,4,10]], n = 4 -> Output: [70,80,30,20]
                Arguments.of(new int[][]{new int[]{1, 3, 20}, new int[]{4, 4, 10}, new int[]{1, 2, 50}, new int[]{2, 4, 10}}, 4, new int[]{70, 80, 30, 20})
        );
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testCorpFlightBookings2(int[][] bookings, int n, int[] expected) {
        // Given
        CorporateFlightBookings solution = new CorporateFlightBookings();

        // When
        int[] result = solution.corpFlightBookings(bookings, n);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testCorpFlightBookings(int[][] bookings, int n, int[] expected) {
        // Given
        CorporateFlightBookings solution = new CorporateFlightBookings();

        // When
        int[] result = solution.corpFlightBookingsQueues(bookings, n);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @MethodSource("parameters")
    @ParameterizedTest
    public void testCorpFlightBookingsBrute(int[][] bookings, int n, int[] expected) {
        // Given
        CorporateFlightBookings solution = new CorporateFlightBookings();

        // When
        int[] result = solution.corpFlightBookingsBrute(bookings, n);

        // Then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}