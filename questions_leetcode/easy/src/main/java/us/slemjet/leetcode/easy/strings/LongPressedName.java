package us.slemjet.leetcode.easy.strings;

public class LongPressedName {

    public static boolean isLongPressedName(String name, String typed) {

        for (int i = 0, j = 0; i < name.length(); i++) {
            if (j >= typed.length() || name.charAt(i) != typed.charAt(j))
                return false;
            else
                j++;

            while ((i < name.length() - 1 && name.charAt(i) != name.charAt(i + 1) || i == name.length() - 1) &&
                    j < typed.length() - 1 && name.charAt(i) == typed.charAt(j))
                j++;
        }
        return true;
    }
}
