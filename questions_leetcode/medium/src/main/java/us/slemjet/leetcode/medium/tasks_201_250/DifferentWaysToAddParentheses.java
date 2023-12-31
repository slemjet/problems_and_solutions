package us.slemjet.leetcode.medium.tasks_201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. Different Ways to Add Parentheses
 */
public class DifferentWaysToAddParentheses {

    /**
     * Time: -> 8.96%
     * Space: -> 11.60%
     */
    public List<Integer> diffWaysToCompute(String expression) {

        Map<String, List<Integer>> memo = new HashMap<>();

        List<Integer> result = calculateComputes(expression, memo);

        return result;
    }

    private List<Integer> calculateComputes(String expression, Map<String, List<Integer>> memo) {

        if (expression.matches("\\d+")) {
            // Is digit
            return List.of(Integer.valueOf(expression));
        }

        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char charAt = expression.charAt(i);

            if (charAt == '+' || charAt == '-' || charAt == '*') {
                // Divide into subproblems than combine and calculate

                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1);

                List<Integer> leftResults = calculateComputes(leftExpression, memo);
                List<Integer> rightResults = calculateComputes(rightExpression, memo);

                for (Integer left : leftResults) {
                    for (Integer right : rightResults) {
                        switch (charAt) {
                            case '+':
                                results.add(left + right);
                                break;
                            case '-':
                                results.add(left - right);
                                break;
                            case '*':
                                results.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        memo.put(expression, results);

        return results;
    }
}
