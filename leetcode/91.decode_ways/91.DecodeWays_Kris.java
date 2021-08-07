// Source : https://leetcode.com/problems/decode-ways/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 ******************************************************************************************************/

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        int n = s.length();
        var dp = new int[n];
        dp[0] = 1;
        if (s.charAt(1) - '0' != 0) {
            dp[1]++;
        }
        var tmp = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        if (tmp >= 10 && tmp <= 26) {
            dp[1]++;
        }
        
        for (var i = 2; i < n; i++) {
            if (s.charAt(i) - '0' != 0) {
                dp[i] += dp[i - 1];
            }
            tmp = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (tmp >= 10 && tmp <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n - 1];
    }
}