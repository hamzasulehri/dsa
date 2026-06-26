package dsa.arrays_strings.optimal;

/*
Problem: Best Time to Buy & Sell Stock
Approach: Optimal
Single pass tracking the minimum price seen so far and the best profit
achievable by selling at the current price.
Time Complexity: O(n)
Space Complexity: O(1)
*/
public class BestTimeToBuySellStockOptimal {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices)); // expected: 5
    }
}
