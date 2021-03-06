package us.slemjet.leetcode.easy.binary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.easy.tree.FirstBadVersion;

import java.util.stream.Stream;

class FirstBadVersionTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(44, 1134903170)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("parameters")
    void climbStairs(int n, int expected) {
        // given
        FirstBadVersion solution = new FirstBadVersion();

        // when
        int ways = solution.firstBadVersion(n);

        // then
        Assertions.assertThat(ways).isEqualTo(expected);
    }
}
