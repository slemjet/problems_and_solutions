package us.slemjet.leetcode.medium.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {

        Map<Character, Integer> mappings = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int result = 0;
        result += mappings.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            // check for prefix
            if (mappings.get(s.charAt(i)) < mappings.get(s.charAt(i + 1)))
                result -= mappings.get(s.charAt(i));
            else
                result += mappings.get(s.charAt(i));
        }
        return result;
    }

    public int romanToInt2(String s) {
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabic = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder letter = new StringBuilder(String.valueOf(s.charAt(i)));

            for (int j = 0; j < roman.length; j++) {
                if (letter.toString().equals(roman[j])) {

                    // need to check for if is a prefix
                    if (i < s.length() - 1) {
                        int k = j;
                        String nextLetter = letter.append(s.charAt(i + 1)).toString();
                        while (k > 0 && !nextLetter.equals(roman[k]))
                            k--;

                        if (nextLetter.equals(roman[k])) {
                            i++;
                            result += arabic[k];
                            break;
                        }
                    }
                    result += arabic[j];
                    break;
                }
            }
        }
        return result;
    }
}
