package us.slemjet.leetcode.easy.tasks_2701_2750;

/**
 * 2706. Buy Two Chocolates
 */
public class BuyTwoChocolates {

    /**
     * Time: O(n) -> 100.00%
     * Space: O(1) -> 5.53%
     */
    public int buyChoco(int[] prices, int money) {

        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                min2 = min;
                min = price;
            } else {
                min2 = Math.min(min2, price);
            }
        }

        return money < min + min2 ? money : money - min - min2;
    }
}
