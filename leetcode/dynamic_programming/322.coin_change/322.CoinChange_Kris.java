// Source : https://leetcode.com/problems/coin-change/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function 
 * to compute the fewest number of coins that you need to make up that amount. If that amount of money 
 * cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 ******************************************************************************************************/

class Solution {
    // dp
    public int coinChange(int[] coins, int amount) {
        var dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (var i = 1; i <= amount; i++) {
            for (var j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    
}