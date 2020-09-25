// Source : https://leetcode.com/problems/perfect-squares/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 
 * 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 ******************************************************************************************************/

class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        var dp = new int[n + 1];
        // 默认都由 1 组成，当然也可以写成 MAX_VALUE
        for (var i = 1; i <= n; i++) {
            dp[i] = n;
        }
        
        // f[i] = MIN{ f[i - j * j] + 1 } | j : 1 ~ j * j <= i
        for (var i = 1; i <= n; i++) {
            for (var j = 1; j * j <= i; j++) {
                // 这里不需要判断 dp[i - j * j] != MAX_VALUE, 因为任意数一定能被分成 n 个 1 相加
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}