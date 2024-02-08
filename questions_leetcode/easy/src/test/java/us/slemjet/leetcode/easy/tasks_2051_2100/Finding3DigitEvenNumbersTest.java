package us.slemjet.leetcode.easy.tasks_2051_2100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Finding3DigitEvenNumbersTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 3, 0}, new int[]{102, 120, 130, 132, 210, 230, 302, 310, 312, 320}),
                Arguments.of(new int[]{2, 2, 8, 8, 2}, new int[]{222, 228, 282, 288, 822, 828, 882}),
                Arguments.of(new int[]{3, 7, 5}, new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindEvenNumbersRec(int[] digits, int[] expected) {
        // given
        Finding3DigitEvenNumbers solution = new Finding3DigitEvenNumbers();

        // when
        int[] result = solution.findEvenNumbersRec(digits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testFindEvenNumbersCheckAll(int[] digits, int[] expected) {
        // given
        Finding3DigitEvenNumbers solution = new Finding3DigitEvenNumbers();

        // when
        int[] result = solution.findEvenNumbersCheckAll(digits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}