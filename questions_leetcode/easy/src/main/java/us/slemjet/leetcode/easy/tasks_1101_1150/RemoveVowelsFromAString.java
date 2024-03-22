package us.slemjet.leetcode.easy.tasks_1101_1150;

import java.util.Set;

/**
 * 1119. Remove Vowels from a String
 */
public class RemoveVowelsFromAString {

    /**
     * Time: O(n)   -> 100.00%
     * Space:O(1)   -> 45.40%
     */
    public String removeVowels(String s) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder result = new StringBuilder();

        for (char letter: s.toCharArray()){
            if(!vowels.contains(letter)){
                result.append(letter);
            }
        }

        return result.toString();
    }
}
