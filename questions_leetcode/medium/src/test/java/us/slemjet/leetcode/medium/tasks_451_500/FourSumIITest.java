package us.slemjet.leetcode.medium.tasks_451_500;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.medium.tasks_451_500.FourSumII;

import java.util.stream.Stream;

class FourSumIITest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
                Arguments.of(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}, 6),
                Arguments.of(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}, 17),
                Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, 1),
                Arguments.of(
                        new int[]{22, -45, 22, -25, 23, -73, -32, -67, -95, 95, -3, -24, 52, -50, -68, -44, -73, -84, 2, -47, 9, 32, -41, 64, 13, -50, 77, -72, -46, 26, 53, 21, -57, -75, -54, 82, 62, -44, 65, 82, 49, -55, 4, 6, 38, -43, -99, 39, 75, -33, -82, 19, -57, 32, -33, -48, 21, -86, 65, -74, 98, -57, 59, 11, -52, 56, -66, -52, -40, 47, 58, 57, 78, -45, 69, -97, -20, -98, -29, -83, -49, -46, -28, -47, 9, -83, -12, 8, -41, -64, -77, 69, -54, 42, 65, -30, -89, 35, 66, -32, 42, 1, -80, 41, -90, -40, 30, -86, -49, -92, 1, -68, -53, 74, -38, 16, -50, 7, -73, 92, -71, -82, 47, 68, 11, -70, -69, 96, -97, -34, -11, 30, -36, -46},
                        new int[]{-78, -40, 60, -22, -28, 53, -99, 17, -99, 26, -78, 5, -38, 12, -37, -84, 59, 36, -71, -26, -79, 38, 80, 42, -90, 44, 47, 57, 15, -10, 98, -77, 80, -100, -46, 72, 74, -84, 33, -7, -8, 45, 8, -2, -97, 18, -31, -78, -32, 61, 1, -58, -76, 95, -64, 70, -72, 14, 82, 2, 37, 87, 9, -12, -35, -58, 37, -53, 12, -59, -22, 42, -79, 96, -56, 47, -51, 33, -94, -54, -4, -80, -91, 73, -11, 84, -50, -57, -18, 4, -6, -31, -95, 14, -10, 51, -12, -12, -62, -28, 100, -3, -25, 98, 85, -10, 7, 68, 68, 48, 18, -22, 41, 95, 12, 73, -42, 18, -94, -69, -95, -47, -62, -85, 27, 59, -27, -27, 30, 87, 2, 21, -20, 34},
                        new int[]{-81, -55, -69, -25, -20, 76, -68, -78, -15, -49, -94, 57, 58, 46, 51, 23, 39, 40, 14, 51, -50, 87, 26, -89, 4, -100, -67, -52, 45, 2, -26, 23, -5, -85, -48, -90, 96, -45, 47, -30, -32, 31, -76, -62, 3, -51, 58, 15, 76, -4, 58, -87, 86, -27, -46, -91, 63, -57, -96, 25, 89, 66, 16, -100, 11, 45, 99, 88, -1, -26, 42, 7, 20, 7, -7, -27, 27, 17, -74, 66, 54, 54, -96, -25, 24, 77, 88, 95, -12, -25, 42, -86, 89, 46, 77, -91, 11, 66, -61, -39, -80, 21, -31, -78, -22, 54, -78, 26, 0, -57, 14, 85, 34, 4, -70, 88, -78, -37, 26, 21, 68, -44, -61, -52, 45, -43, 21, 36, 79, -61, 16, -13, -67, 43},
                        new int[]{7, -2, -33, 77, -88, -50, 60, -19, 37, 12, -8, 87, 76, 38, -82, 82, 11, 31, -24, -37, -3, -7, -69, -63, -20, 98, 42, -45, -44, 79, 48, 51, -7, -15, -97, -46, 83, -100, 23, -56, -7, 43, 6, -81, -22, -44, 13, 85, 15, -54, 42, -82, 97, 69, 83, -84, -22, -34, 98, -89, 69, 58, 96, 61, -22, 38, -45, -22, -53, 52, 65, -9, 99, 31, -53, -55, -45, -26, -48, -34, -65, 54, 88, 100, -45, -4, -7, -30, 12, -55, 68, 91, -99, 47, -64, -87, 35, -73, -73, -41, 74, 59, -90, 10, -85, -15, -39, 19, 14, -12, -10, -1, 63, -52, -45, -40, 54, -66, -19, -47, 60, 35, -59, -99, -41, -44, 43, -53, 7, -3, 31, 73, 7, 15},
                        1084670)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
        // given
        FourSumII solution = new FourSumII();

        // when
        int result = solution.fourSumCount(nums1, nums2, nums3, nums4);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
        // given
        FourSumII solution = new FourSumII();

        // when
        int result = solution.fourSumCount2(nums1, nums2, nums3, nums4);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFourSumCountBrute(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
        // given
        FourSumII solution = new FourSumII();

        // when
        int result = solution.fourSumCountBrute(nums1, nums2, nums3, nums4);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}