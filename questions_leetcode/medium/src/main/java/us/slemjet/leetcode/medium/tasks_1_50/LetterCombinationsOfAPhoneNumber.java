package us.slemjet.leetcode.medium.tasks_1_50;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    private Map<Character, List<String>> digitMappings = new HashMap<Character, List<String>>() {{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty())
            return result;

        if (Character.isDigit(digits.charAt(0)))
            result = getIntersection(digitMappings.get(digits.charAt(0)), digits.substring(1));

        return result;
    }

    private List<String> getIntersection(List<String> strings, String digits) {
        if (digits.isEmpty() || !Character.isDigit(digits.charAt(0)) && digitMappings.get(digits.charAt(0)) != null) {
            return strings;
        }
        List<String> strings2 = digitMappings.get(digits.charAt(0));
        List<String> intersection = new ArrayList<>();
        for (String string : strings) {
            intersection.add(string + strings2.get(0));
            intersection.add(string + strings2.get(1));
            intersection.add(string + strings2.get(2));
            if (strings2.size() == 4)
                intersection.add(string + strings2.get(3));
        }
        return getIntersection(intersection, digits.substring(1));
    }
}
