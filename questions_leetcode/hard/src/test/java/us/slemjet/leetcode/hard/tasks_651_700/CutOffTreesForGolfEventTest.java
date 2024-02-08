package us.slemjet.leetcode.hard.tasks_651_700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class CutOffTreesForGolfEventTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 2, 3), List.of(0, 0, 4), List.of(7, 6, 5)), 6),
                Arguments.of(List.of(List.of(1, 2, 3), List.of(0, 0, 0), List.of(7, 6, 5)), -1),
                Arguments.of(List.of(List.of(2, 3, 4), List.of(0, 0, 5), List.of(8, 7, 6)), 6),
                Arguments.of(List.of(List.of(4, 2, 3), List.of(0, 0, 1), List.of(7, 6, 5)), 10),
                Arguments.of(List.of(
                        List.of(9, 12, 5, 14),
                        List.of(17, 11, 13, 15),
                        List.of(2, 20, 19, 21),
                        List.of(16, 4, 7, 8),
                        List.of(18, 3, 6, 10)), 57),
                Arguments.of(List.of(
                        List.of(54581641, 64080174, 24346381, 69107959),
                        List.of(86374198, 61363882, 68783324, 79706116),
                        List.of(668150, 92178815, 89819108, 94701471),
                        List.of(83920491, 22724204, 46281641, 47531096),
                        List.of(89078499, 18904913, 25462145, 60813308)), 57),
                Arguments.of(List.of(
                        List.of(4557,   6199,   7461,   2554,   6132,   7471,   7103,   4290),
                        List.of(2034,   2301,   6733,   6040,   2603,   5697,   9541,   6678),
                        List.of(7308,   7368,   9618,   4386,   6944,   3923,   4754,   4294),
                        List.of(0,      3016,   7242,   5284,   6631,   1897,   1767,   7603),
                        List.of(2228,   0,      3625,   7713,   2956,   3264,   3371,   6124),
                        List.of(9195,   7804,   2787,   0,      4919,   9304,   5161,   502)), 202),
                Arguments.of(List.of(List.of(0), List.of(0), List.of(614)), -1));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCutOffTree(List<List<Integer>> forest, int expected) {
        // given
        CutOffTreesForGolfEvent solution = new CutOffTreesForGolfEvent();

        // when
        int result = solution.cutOffTree(forest);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCutOffTree2(List<List<Integer>> forest, int expected) {
        // given
        CutOffTreesForGolfEvent solution = new CutOffTreesForGolfEvent();

        // when
        int result = solution.cutOffTree2(forest);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testCutOffTree3(List<List<Integer>> forest, int expected) {
        // given
        CutOffTreesForGolfEvent solution = new CutOffTreesForGolfEvent();

        // when
        int result = solution.cutOffTree3(forest);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}