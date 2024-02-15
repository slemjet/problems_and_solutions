package us.slemjet.leetcode.medium.tasks_2101_2150;

/**
 * 2149. Rearrange Array Elements by Sign
 */
public class RearrangeArrayElementsBySign {

    /**
     * Time: O(n)   ->  100.00%
     * Space: O(n)  ->  74.37%
     */
    public int[] rearrangeArray(int[] nums) {

        int[] result = new int[nums.length];
        int negIdx = 1; // Next negative (starts from idx 1)
        int posIdx = 0;

        for (int i = 0; i < result.length; i++) {

            if (nums[i] > 0) {
                result[posIdx] = nums[i];
                posIdx += 2; // Set next positive idx
            } else {
                result[negIdx] = nums[i];
                negIdx += 2; // Set next negative idx
            }
        }

        return result;
    }

    /**
     *
     */
    public int[] rearrangeArray2(int[] nums) {

        int[] result = new int[nums.length];
        int negIdx = 0;
        int posIdx = 0;

        for (int i = 0; i < result.length; i++) {

            if (i % 2 == 1) {
                // get next negative
                while (nums[negIdx] >= 0) {
                    negIdx++;
                }
                result[i] = nums[negIdx++];
            } else {
                // get next positive
                while (nums[posIdx] < 0) {
                    posIdx++;
                }
                result[i] = nums[posIdx++];
            }
        }

        return result;
    }
}
