// Source : https://leetcode.com/problems/longest-valid-parentheses/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid 
 * (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * Example 2:
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 ******************************************************************************************************/

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        var ss = s.toCharArray();
        
        var dp = new int[ss.length];
        var max = 0;
        for (var i = 1; i < ss.length; i++) {
            if (ss[i] == ')' && i - dp[i - 1] - 1 >= 0 && ss[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2;
                
                if (i - dp[i - 1] - 2 > 0) {
                    dp[i] += dp[i - dp[i - 1] - 2];
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}