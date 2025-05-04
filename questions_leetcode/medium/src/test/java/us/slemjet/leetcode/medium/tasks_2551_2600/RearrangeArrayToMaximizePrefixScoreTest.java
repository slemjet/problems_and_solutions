package us.slemjet.leetcode.medium.tasks_2551_2600;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RearrangeArrayToMaximizePrefixScoreTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, -1, 0, 1, -3, 3, -3}, 6),
                Arguments.of(new int[]{-2, -3, 0}, 0),
                Arguments.of(new int[]{-687767, -860350, 950296, 52109, 510127, 545329, -291223, -966728, 852403, 828596, 456730, -483632, -529386, 356766, 147293, 572374, 243605, 931468, 641668, 494446}, 20)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionSort(int[] nums, int expected) {
        // given
        RearrangeArrayToMaximizePrefixScore solution = new RearrangeArrayToMaximizePrefixScore();

        // when
        int result = solution.maxScoreSort(nums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}