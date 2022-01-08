package us.slemjet.leetcode.medium.tasks_351_400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * Runtime: 28.17%
     * Memory Usage: 17.88%
     */
    public int longestSubstring(String s, int k) {

        // Count how many occurrences of each char
        Map<Character, Long> frequencyMap = s.codePoints().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Get chars that cannot be included
        Set<Character> incorrectChars = frequencyMap.entrySet().stream().filter(entry -> entry.getValue() < k).map(Map.Entry::getKey).collect(Collectors.toSet());
        // Convert incorrect chars to delimiter regex
        String delimiters = incorrectChars.stream().map(Object::toString).collect(Collectors.joining("|"));

        if (delimiters.isEmpty()) {
            // Full string can be an answer
            return s.length();
        } else {
            // Get potential candidates - strings that do not contain incorrect chars
            String[] candidateStrings = s.split(delimiters);
            // Recursively call this method for each candidate, returning max candidate length
            return Arrays.stream(candidateStrings).map(candidate -> longestSubstring(candidate, k)).max(Integer::compareTo).orElse(0);
        }
    }
}
