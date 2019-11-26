package com.slemjet.questions.other;

import java.util.HashSet;
import java.util.Set;

public class PermutationsFinder {

    public static Set<String> solution(String input) {
        Set<String> result = new HashSet<>();
        if (input.length() == 1)
            result.add(input);
        else {
            for (int i = 0; i < input.length(); i++) {
                // try each character as first and permutate remaining 2 subsets
                Set<String> subSolutions = solution(input.substring(0, i) + input.substring(i + 1));
                for (String subString : subSolutions) {
                    result.add(input.charAt(i) + subString); // starting from current character as first
                }
            }
        }
        return result;
    }
}
