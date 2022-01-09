package us.slemjet.leetcode.easy.from_401_to_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 */
public class FizzBuzz {

    /**
     * Runtime: 99.67%
     * Memory Usage: 73.15%
     */
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    result.add("FizzBuzz");
                } else {
                    result.add("Fizz");
                }
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
