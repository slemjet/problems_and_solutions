package us.slemjet.leetcode.easy.tasks_751_800;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tasks_751_800.JewelsAndStones;

import java.util.stream.Stream;

class JewelsAndStonesTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("aA", "aAAbbbb", 3),
                Arguments.of("z", "ZZ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void reverseTest(String J, String S, int expected) {
        // given
        JewelsAndStones solution = new JewelsAndStones();

        // when
        int result = solution.numJewelsInStones(J, S);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
