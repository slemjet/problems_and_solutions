package us.slemjet.leetcode.medium.tasks_901_950;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class RevealCardsInIncreasingOrderTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{17, 13, 11, 2, 3, 5, 7}, new int[]{2, 13, 3, 11, 5, 17, 7}),
                of(new int[]{1, 1000}, new int[]{1, 1000})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int[] deck, int[] expected) {
        // given
        RevealCardsInIncreasingOrder solution = new RevealCardsInIncreasingOrder();

        // when
        int[] result = solution.deckRevealedIncreasing(deck);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}