package us.slemjet.leetcode.easy.strings;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if (needle.equals(""))
            return 0;

        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            String candidate = haystack.substring(i, i + needle.length());
            if (needle.equals(candidate))
                return i;
        }

        return -1;
    }

    /**
     * Use KMP algorithm to find string pattern match
     * with this approach we do not need to traverse back once certain character does not match
     * more memory efficient
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {

        if (needle.equals(""))
            return 0;
        int[] kmp = calculateKmpTable(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = kmp[j - 1]; // fallback to prev char in pattern

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) // match found
                    return i - j + 1; // index is relative to prefix index j
            }
        }

        return -1;
    }

    private int[] calculateKmpTable(String needle) {
        int[] kmp = new int[needle.length()];
        for (int i = 1; i < needle.length(); i++) {
            int j = kmp[i - 1];

            while (j > 0 && needle.charAt(i) != needle.charAt(j))
                j = kmp[j - 1];

            if (needle.charAt(i) == needle.charAt(j))
                j++;

            kmp[i] = j;
        }
        return kmp;
    }
}
