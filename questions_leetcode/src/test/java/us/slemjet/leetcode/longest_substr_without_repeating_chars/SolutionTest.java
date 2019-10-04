package us.slemjet.leetcode.longest_substr_without_repeating_chars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void lengthOfLongestSubstring() {
        // given
        var solution = new Solution();

        // when
        var length1 = solution.lengthOfLongestSubstring("abcabcbb");
        var length2 = solution.lengthOfLongestSubstring("bbbbb");
        var length3 = solution.lengthOfLongestSubstring("pwwkew");
        var length4 = solution.lengthOfLongestSubstring(" ");
        var length5 = solution.lengthOfLongestSubstring("");
        var length6 = solution.lengthOfLongestSubstring("dvdf");
        var length7 = solution.lengthOfLongestSubstring("au");

        // then
        Assertions.assertThat(length1).isEqualTo(3);
        Assertions.assertThat(length2).isEqualTo(1);
        Assertions.assertThat(length3).isEqualTo(3);
        Assertions.assertThat(length4).isEqualTo(1);
        Assertions.assertThat(length5).isEqualTo(0);
        Assertions.assertThat(length6).isEqualTo(3);
        Assertions.assertThat(length7).isEqualTo(2);
    }
}