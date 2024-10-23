package us.slemjet.leetcode.medium.tasks_401_450;

/**
 * 423. Reconstruct Original Digits from English
 */
public class ReconstructOriginalDigitsFromEnglish {

    /**
     * Time: O(n)   ->  89.27%
     * Space:O(n)   ->  55.84%
     */
    public String originalDigits(String s) {

        // zero one two three four five six seven eight nine
        // unique chars - first group
        // zero -> 'z'
        // two  -> 'w'
        // four -> 'u'
        // six  -> 'x'
        // eight-> 'g'
        // after removing all of these remaining: one three five seven nine
        // unique char - second group
        // one -> 'o'
        // three->'h', 'r'
        // five -> 'f'
        // seven-> 's'
        // Remaining will be nines

        String result = "";

        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int[] digitCounts = new int[10];
        // Count zeroes
        digitCounts[0] = charCounts['z' - 'a'];
        charCounts['z' - 'a']-= digitCounts[0];
        charCounts['e' - 'a']-= digitCounts[0];
        charCounts['r' - 'a']-= digitCounts[0];
        charCounts['o' - 'a']-= digitCounts[0];

        // Count twos
        digitCounts[2] = charCounts['w' - 'a'];
        charCounts['t' - 'a']-= digitCounts[2];
        charCounts['w' - 'a']-= digitCounts[2];
        charCounts['o' - 'a']-= digitCounts[2];

        // Count fours
        digitCounts[4] = charCounts['u' - 'a'];
        charCounts['f' - 'a']-= digitCounts[4];
        charCounts['o' - 'a']-= digitCounts[4];
        charCounts['u' - 'a']-= digitCounts[4];
        charCounts['r' - 'a']-= digitCounts[4];

        // Count sixes
        digitCounts[6] = charCounts['x' - 'a'];
        charCounts['s' - 'a']-= digitCounts[6];
        charCounts['i' - 'a']-= digitCounts[6];
        charCounts['x' - 'a']-= digitCounts[6];

        // Count eights
        digitCounts[8] = charCounts['g' - 'a'];
        charCounts['e' - 'a']-= digitCounts[8];
        charCounts['i' - 'a']-= digitCounts[8];
        charCounts['g' - 'a']-= digitCounts[8];
        charCounts['h' - 'a']-= digitCounts[8];
        charCounts['t' - 'a']-= digitCounts[8];

        // Count ones
        digitCounts[1] = charCounts['o' - 'a'];
        charCounts['o' - 'a']-= digitCounts[1];
        charCounts['n' - 'a']-= digitCounts[1];
        charCounts['e' - 'a']-= digitCounts[1];

        // Count threes
        digitCounts[3] = charCounts['h' - 'a'];
        charCounts['t' - 'a']-= digitCounts[3];
        charCounts['h' - 'a']-= digitCounts[3];
        charCounts['r' - 'a']-= digitCounts[3];
        charCounts['e' - 'a']-= digitCounts[3] * 2;

        // Count fives
        digitCounts[5] = charCounts['f' - 'a'];
        charCounts['f' - 'a']-= digitCounts[5];
        charCounts['i' - 'a']-= digitCounts[5];
        charCounts['v' - 'a']-= digitCounts[5];
        charCounts['e' - 'a']-= digitCounts[5];

        // Count sevens
        digitCounts[7] = charCounts['s' - 'a'];
        charCounts['s' - 'a']-= digitCounts[7];
        charCounts['e' - 'a']-= digitCounts[7] * 2;
        charCounts['v' - 'a']-= digitCounts[7];
        charCounts['n' - 'a']-= digitCounts[7];

        // Count nines
        digitCounts[9] = charCounts['i' - 'a'];
        charCounts['n' - 'a']-= digitCounts[9] * 2;
        charCounts['i' - 'a']-= digitCounts[9];
        charCounts['e' - 'a']-= digitCounts[9];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i).repeat(Math.max(0, digitCounts[i])));
        }

        return sb.toString();
    }
}
