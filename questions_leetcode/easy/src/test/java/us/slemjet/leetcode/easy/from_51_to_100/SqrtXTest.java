package us.slemjet.leetcode.easy.from_51_to_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SqrtXTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(8, 2),
                Arguments.of(36, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void mySqrt(int x, int expected) {
        // given
        SqrtX solution = new SqrtX();

        // when
        int result = solution.mySqrt(x);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
