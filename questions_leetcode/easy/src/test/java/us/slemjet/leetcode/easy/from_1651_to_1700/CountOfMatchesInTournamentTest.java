package us.slemjet.leetcode.easy.from_1651_to_1700;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.from_1251_to_1300.MinimumTimeVisitingAllPoints;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountOfMatchesInTournamentTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(7, 6),
                Arguments.of(14, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(int n, int expected) {
        // given
        CountOfMatchesInTournament solution = new CountOfMatchesInTournament();

        // when
        int result = solution.numberOfMatches(n);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}