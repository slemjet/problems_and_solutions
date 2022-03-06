package us.slemjet.leetcode.hard.from_1351_to_1400;

/**
 * 1359. Count All Valid Pickup and Delivery Options
 */
public class CountAllValidPickupAndDeliveryOptions {

    /**
     * Runtime: 100.00%
     * Memory Usage: 39.23%
     */
    public int countOrders(int n) {

        int modulo = (int) (Math.pow(10, 9) + 7); // We use modulo to handle super large numbers
        int[] orders = new int[n + 1];
        orders[1] = 1;

        for (int i = 2; i <= n; i++) {

            // Formula: o(n) = n * (2n - 1) * o(n -1)
            // Logic with modulo: (a * b) % c = ((a % c) + (b % c)) % c

            long order = i * (2L * i - 1) * orders[i - 1];
            orders[i] = (int) (order % modulo);
        }

        return orders[n];
    }
}
