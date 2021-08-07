// Source : https://leetcode.com/problems/knight-dialer/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * The chess knight has a unique movement, it may move two squares vertically and one square 
 * horizontally, or two squares horizontally and one square vertically (with both forming the shape of 
 * an L). The possible movements of chess knight are shown in this diagaram:
 * 
 * A chess knight can move as indicated in the chess diagram below:
 * 
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell 
 * (i.e. blue cell).
 * 
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * 
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 
 * jumps to dial a number of length n. All jumps should be valid knight jumps.
 * 
 * As the answer may be very large, return the answer modulo 109 + 7.
 * 
 * Example 1:
 * 
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of 
 * the 10 cells is sufficient.
 * 
 * Example 2:
 * 
 * Input: n = 2
 * Output: 20
 * Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 
 * 61, 67, 72, 76, 81, 83, 92, 94]
 * 
 * Example 3:
 * 
 * Input: n = 3
 * Output: 46
 * 
 * Example 4:
 * 
 * Input: n = 4
 * Output: 104
 * 
 * Example 5:
 * 
 * Input: n = 3131
 * Output: 136006598
 * Explanation: Please take care of the mod.
 * 
 * Constraints:
 * 
 * 	1 <= n <= 5000
 ******************************************************************************************************/

class Solution {
    public int knightDialer(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 10;
        }
        
        int mod = 1_000_000_007;
        int[][] moves = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        
        var dp = new int[n + 1][10];
        for (var i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (var i = 2; i <= n; i++) {
            for (var j = 0; j < 10; j++) {
                for (var previousNumber : moves[j]) {
                    dp[i][j] += dp[i - 1][previousNumber];
                    dp[i][j] %= mod;
                }
            }
        }
        
        var result = 0;
        for (var i = 0; i < 10; i++) {
            result += dp[n][i];
            result %= mod;
        }
        
        return result;
    }
    
    // 暴力解法，懒得优化常数项了。。 O(4 * 3 * 8 * n)
    // 可以提前把跳的下一步准备好，这样可以把 8 优化掉
    // int[][] moves = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    public int knightDialer_2(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 10;
        }
        
        int mod = 1_000_000_007;
        int[][] phone = {{1,2,3}, {4,-1,6}, {7,8,9}, {-1,0,-1}};
        var dp = new int[n + 1][4][3];
        for (var i = 0; i < phone.length; i++) {
            for (var j = 0; j < phone[i].length; j++) {
                if (phone[i][j] != -1) {
                    dp[1][i][j] = 1;
                }
            }
        }
        
        int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[] dy = {2, 2, 1, 1, -1, -1, -2, -2};
        for (var i = 2; i <= n; i++) {
            for (var j = 0; j < phone.length; j++) {
                for (var k = 0; k < phone[j].length; k++) {
                    if (phone[j][k] == -1) {
                        continue;
                    }
                    
                    for (var p = 0; p < dx.length; p++) {
                        var row = j + dx[p];
                        var col = k + dy[p];
                        if (row >= 0 && row < 4 && col >= 0 && col < 3
                            && phone[row][col] != -1) {
                            dp[i][j][k] += dp[i - 1][row][col];
                            dp[i][j][k] %= mod;
                        }
                    }
                }
            }
        }
        
        var result = 0;
        for (var i = 0; i < phone.length; i++) {
            for (var j = 0; j < phone[i].length; j++) {
                if (phone[i][j] != -1) {
                    result += dp[n][i][j];
                    result %= mod;
                }
            }
        }
        
        return result;
    }
}