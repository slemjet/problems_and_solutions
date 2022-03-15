package us.slemjet.leetcode.medium.tasks_51_100;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SimplifyPathTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/../", "/"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/a//b////c/d//././/..", "/a/b/c")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testSimplifyPath(String path, String expected) {
        // given
        SimplifyPath solution = new SimplifyPath();

        // when
        String isValid = solution.simplifyPath(path);

        // then
        Assertions.assertThat(isValid).isEqualTo(expected);
    }
}