package sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class MergeSortTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                of(new int[]{5, 1, 7, 3, 4, 8, 2, 6, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                of(new int[]{5, 6, 2, 5, 6, 3, 1, 6, 2}, new int[]{1, 2, 2, 3, 5, 5, 6, 6, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMergeSort(int[] array, int[] expected) {
        // given
        MergeSort solution = new MergeSort();

        // when
        solution.mergeSort(array);

        // then
        Assertions.assertThat(array).isEqualTo(expected);
    }
}