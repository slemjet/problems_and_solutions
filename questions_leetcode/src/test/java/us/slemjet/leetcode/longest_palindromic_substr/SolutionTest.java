package us.slemjet.leetcode.longest_palindromic_substr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestPalindrome1() {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome("babad");

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo("bab");
    }

    @Test
    void longestPalindrome2() {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome("cbbd");

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo("bb");
    }

    @Test
    void longestPalindrome3() {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome("ccc");

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo("ccc");
    }

    @Test
    void longestPalindrome4() {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome("aaaa");

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo("aaaa");
    }

    @Test
    void longestPalindrome5() {
        // given
        Solution solution = new Solution();

        // when
        String longestPalindrome = solution.longestPalindrome("tattarrattat");

        // then
        Assertions.assertThat(longestPalindrome).isEqualTo("tattarrattat");
    }
}