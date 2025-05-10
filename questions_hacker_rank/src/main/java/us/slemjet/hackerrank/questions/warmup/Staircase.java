package us.slemjet.hackerrank.questions.warmup;

/**
 *
 */
public class Staircase {

    /**
     * Time:    O(n)
     * Space:   O(1)
     */
    public void staircase(int n) {

        // Write your code here
        StringBuilder sb = new StringBuilder();

        sb.append(" ".repeat(n));

        for (int i = 0; i < n; i++) {
            sb.replace(n - i - 1, n - i, "#");
            System.out.println(sb);
        }
    }
}
