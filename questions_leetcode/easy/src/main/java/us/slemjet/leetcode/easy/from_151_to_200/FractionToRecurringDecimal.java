package us.slemjet.leetcode.easy.from_151_to_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 */
public class FractionToRecurringDecimal {

    /**
     * Runtime: 100.00%
     * Memory Usage: 68.42%
     */
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        // Process values having different signs
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        // Need to use long in case of -2147483648
        long longNumerator = Math.abs((long)numerator);
        long longDenominator = Math.abs((long)denominator);
        long integral = longNumerator / longDenominator;
        result.append(sign);
        result.append(integral);

        long fraction = longNumerator % longDenominator;
        int fractionIdx = 0;
        if (fraction != 0) {
            result.append(".");
            fractionIdx = result.length();
        }

        // Store remainders so in case repetitive values occurs brackets can be placed
        Map<Long, Integer> remainders = new HashMap<>();
        int index = 0;
        while (fraction != 0) {
            fraction *= 10;
            integral = fraction / longDenominator;

            // Check if we've already processed this fraction and there is repetition
            if (remainders.containsKey(fraction)) {
                int bracketIdx = remainders.get(fraction) + fractionIdx;
                result.insert(bracketIdx, "(");
                result.append(")");
                break;
            } else {
                result.append(integral);
                remainders.put(fraction, index++);
            }
            fraction = fraction % longDenominator;
        }
        return result.toString();
    }
}
