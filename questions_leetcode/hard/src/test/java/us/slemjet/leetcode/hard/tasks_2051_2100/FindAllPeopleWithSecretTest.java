package us.slemjet.leetcode.hard.tasks_2051_2100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class FindAllPeopleWithSecretTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(6, new int[][]{new int[]{1, 2, 5}, new int[]{2, 3, 8}, new int[]{1, 5, 10}}, 1, List.of(0, 1, 2, 3, 5)),
                Arguments.of(4, new int[][]{new int[]{3, 1, 3}, new int[]{1, 2, 2}, new int[]{0, 3, 3}}, 3, List.of(0, 1, 3)),
                Arguments.of(5, new int[][]{new int[]{3, 4, 2}, new int[]{1, 2, 1}, new int[]{2, 3, 1}}, 1, List.of(0, 1, 2, 3, 4)),
                Arguments.of(5, new int[][]{new int[]{1, 4, 3}, new int[]{0, 4, 3}}, 3, List.of(0, 1, 3, 4)),
                Arguments.of(6, new int[][]{new int[]{0, 2, 1}, new int[]{1, 3, 1}, new int[]{4, 5, 1}}, 3, List.of(0, 1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionBFS(int n, int[][] meetings, int firstPerson, List<Integer> expected) {
        // given
        FindAllPeopleWithSecret solution = new FindAllPeopleWithSecret();

        // when
        List<Integer> result = solution.findAllPeopleBFS(n, meetings, firstPerson);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionDFS(int n, int[][] meetings, int firstPerson, List<Integer> expected) {
        // given
        FindAllPeopleWithSecret solution = new FindAllPeopleWithSecret();

        // when
        List<Integer> result = solution.findAllPeopleDFS(n, meetings, firstPerson);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolutionUnionFind(int n, int[][] meetings, int firstPerson, List<Integer> expected) {
        // given
        FindAllPeopleWithSecret solution = new FindAllPeopleWithSecret();

        // when
        List<Integer> result = solution.findAllPeopleUnionFind(n, meetings, firstPerson);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}