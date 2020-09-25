// Source : https://leetcode.com/problems/climbing-stairs/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example 1:
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Constraints:
 * 
 * 	1 <= n <= 45
 ******************************************************************************************************/

class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        var dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (var i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        
        return dp[n];
    }
}