// Source : https://leetcode.com/problems/maximal-square/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and 
 * return its area.
 * 
 * Example:
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 ******************************************************************************************************/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        var m = matrix.length;
        var n = matrix[0].length;
        var dp = new int[m][n];
        var max = 0;
        for (var i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        for (var j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(dp[0][j], max);
        }
        
        for (var i = 1; i < m; i++) {
            for (var j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return max * max;
    }
}