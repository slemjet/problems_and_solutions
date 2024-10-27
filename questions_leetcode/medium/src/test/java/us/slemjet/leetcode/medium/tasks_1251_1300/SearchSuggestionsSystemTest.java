package us.slemjet.leetcode.medium.tasks_1251_1300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SearchSuggestionsSystemTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse",
                        List.of(List.of("mobile", "moneypot", "monitor"),
                                List.of("mobile", "moneypot", "monitor"),
                                List.of("mouse", "mousepad"),
                                List.of("mouse", "mousepad"),
                                List.of("mouse", "mousepad"))),
                Arguments.of(new String[]{"havana"}, "havana",
                        List.of(List.of("havana"),
                                List.of("havana"),
                                List.of("havana"),
                                List.of("havana"),
                                List.of("havana"),
                                List.of("havana"))),
                Arguments.of(new String[]{"havana"}, "tatiana",
                        List.of(List.of(), List.of(), List.of(), List.of(), List.of(), List.of(), List.of()))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSolution(String[] products, String searchWord, List<List<String>> expected) {
        // given
        SearchSuggestionsSystem solution = new SearchSuggestionsSystem();

        // when
        List<List<String>> result = solution.suggestedProducts(products, searchWord);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}