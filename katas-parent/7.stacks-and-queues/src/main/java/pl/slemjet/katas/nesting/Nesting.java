package pl.slemjet.katas.nesting;

public class Nesting {

    public static int solution(String S) {
        // write your code in Java SE 8
        int opened = 0;

        for (int i = 0; i < S.length(); i++) {
            opened += (S.charAt(i) == '(') ? 1 : -1;
            if (opened < 0) // invalid structure
                return 0;
        }

        return opened == 0 ? 1 : 0;
    }
}
