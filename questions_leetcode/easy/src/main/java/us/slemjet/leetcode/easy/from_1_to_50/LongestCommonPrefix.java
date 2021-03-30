package us.slemjet.leetcode.easy.from_1_to_50;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int index = 0;
        int codePoint = 0;

        while (true) {
            for (String str : strs) {
                if (str.length() == index)
                    return str.substring(0, index);

                if (codePoint == 0) // first char - set as base for compare
                    codePoint = str.codePointAt(index);

                if (codePoint != str.codePointAt(index))
                    return str.substring(0, index);

            }
            codePoint = 0; // reset as last string is reached
            index++;
        }
    }
}
