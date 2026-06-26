package dsa.arrays_strings.brute;

/*
Problem: Best Time to Buy & Sell Stock
Approach: Brute Force
Check every pair (buy day, sell day) where sell day is after buy day,
and track the maximum profit found.
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
public class BestTimeToBuySellStockBrute {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices)); // expected: 5
    }
}
