// Source : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * 
 * 	You may not engage in multiple transactions at the same time (ie, you must sell the stock 
 * before you buy again).
 * 	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * 
 * Example:
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 ******************************************************************************************************/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        // 0: cooldown, 1: 持有, 2: sell
        var dp = new int[prices.length + 1][3];
        
        for (var i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);  
            dp[i][1] = dp[i - 1][0];
            
            if (i >= 2) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + prices[i - 1] - prices[i - 2]);
                dp[i][2] = dp[i - 1][1] + prices[i - 1] - prices[i - 2];
            }
        }
        
        return Math.max(Math.max(dp[prices.length][0], dp[prices.length][1]), dp[prices.length][2]);
    }
}