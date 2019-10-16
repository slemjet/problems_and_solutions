package us.slemjet.leetcode.easy.arrays.is_palindrome_number;

import java.util.*;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        if (x == 0)
            return true;

        List<Integer> list = new LinkedList<>();

        while (x != 0) {
            int nextInt = x % 10;
            list.add(nextInt);
            x /= 10;
        }

        Iterator<Integer> iterator = list.iterator();
        ListIterator<Integer> iteratorRev = list.listIterator(list.size());

        while (iterator.hasNext() && iteratorRev.hasPrevious()) {
            Integer previous = iteratorRev.previous();
            Integer next = iterator.next();
            if (!next.equals(previous))
                return false;
            if (iteratorRev.previousIndex() < list.size() / 2)
                return true;
        }

        return false;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;

        if (x == 0)
            return true;

        List<Integer> list = new ArrayList<>();

        while (x != 0) {
            int nextInt = x % 10;
            list.add(nextInt);
            x /= 10;
        }

        int start = 0, end = list.size() - 1;

        while (start <= end) {
            if (!list.get(start++).equals(list.get(end--)))
                return false;
        }

        return true;
    }

    public boolean isPalindrome3(int x) {
            if (x < 0 || (x % 10 == 0 && x > 0))
                return false;

            if (x == 0)
                return true;

            // revert half of the palindrome and compare it with the other half
            int revertedHalf = 0;
            while (x > revertedHalf) {
                revertedHalf = revertedHalf * 10 + x % 10;
                x /= 10;
            }
            // revertedHalf / 10 to get rid of the middle digit (odd case)
            return x == revertedHalf || x == revertedHalf / 10;
    }
}
