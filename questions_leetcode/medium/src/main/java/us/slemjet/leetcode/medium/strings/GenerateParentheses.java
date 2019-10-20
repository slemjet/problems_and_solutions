package us.slemjet.leetcode.medium.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateResults(result, "", 0, 0, n);
        return result;
    }

    private void generateResults(List<String> result, String currString, int open, int closed, int total) {
        if (currString.length() == total * 2) {
            // solution found
            result.add(currString);
            return;
        }

        if (open < total) // can add opening parenthesis "("
            generateResults(result, currString + "(", open + 1, closed, total);
        if (closed < open) // can add closing parenthesis ")"
            generateResults(result, currString + ")", open, closed + 1, total);
    }

    public List<String> generateParenthesisDynamic(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            // F(0) = ""
            // F(1) = "(F(0))F(1), (F(1))"
            // F(1) = "(F(0))F(2), (F(1))F(1), (F(2))"
            // F(1) = "(F(0))F(n-1), (F(1))F(n-2), (F(2))F(n-3)...(F(i)F(n-i-1)), (F(n-1))"
            // result will be "(" + F(n) + ")" + F(n - 1 - i)
            for (int i = 0; i < n; i++) {
                for (String left : generateParenthesisDynamic(i))
                    for (String right : generateParenthesisDynamic(n - 1 - i))
                        result.add("(" + left + ")" + right);
            }
        }
        return result;
    }
}
