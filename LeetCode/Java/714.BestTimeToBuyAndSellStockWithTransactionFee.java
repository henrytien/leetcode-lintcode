// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// Author : Ubique0305
// Date   : 2020-07-11

/***************************************************************************************************** 
 *
 * Your are given an array of integers prices, for which the i-th element is the price of a given 
 * stock on day i; and a non-negative integer fee representing a transaction fee.
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each 
 * transaction.  You may not buy more than 1 share of a stock at a time (ie. you must sell the stock 
 * share before you buy again.)
 * Return the maximum profit you can make.
 * 
 * Example 1:
 * 
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] = 4Selling at prices[5] = 9The 
 * total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * Note:
 * 0 .
 * 0 .
 * 0 .
 ******************************************************************************************************/
/*
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i] - fee)
*/
class Solution {
    int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
        int temp = dp_i_0;
        dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
        dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
    }
    return dp_i_0;
}
}
