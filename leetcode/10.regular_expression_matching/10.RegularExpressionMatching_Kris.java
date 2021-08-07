// Source : https://leetcode.com/problems/regular-expression-matching/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for 
 * '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 	s could be empty and contains only lowercase letters a-z.
 * 	p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * 
 * Example 1:
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * Example 2:
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' 
 * once, it becomes "aa".
 * 
 * Example 3:
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * Example 4:
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * 
 * Example 5:
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 ******************************************************************************************************/

class Solution {
    public boolean isMatch(String s, String p) {
        var dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 只有 a*b*c* 这种场景可以匹配空串，只需判断 * 位，即 j-1 = 1，3，5...
        for (var j = 2; j <= p.length(); j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (var i = 1; i <= s.length(); i++) {
            for (var j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (j - 2 < 0) {
                        throw new RuntimeException("Invalid pattern");
                    }

                    // 不使用 p.charAt(j - 2)* 进行匹配
                    dp[i][j] = dp[i][j - 2]; 

                    // 使用 p.charAt(j - 2)* 进行匹配
                    // 那么必然要求 s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        // 只需要计算前面的 dp[i - 1][j] 是否匹配即可
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}