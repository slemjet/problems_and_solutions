package us.slemjet.leetcode.easy.from_51_to_100;

/**
 * Runtime: 100.00%
 * Memory Usage: 94.70%
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        if (a == null || "".equals(a)) return b;
        if (b == null || "".equals(b)) return a;

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder result = new StringBuilder();
        byte carry = 0;

        while (i >= 0 || j >= 0){
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2); // value is a remainder of division
            carry = (byte) (sum / 2); // set carry if sum is 2
        }

        if (carry == 1) { // add last remaining bit
            result.append("1");
        }

        return result.reverse().toString();
    }
}
