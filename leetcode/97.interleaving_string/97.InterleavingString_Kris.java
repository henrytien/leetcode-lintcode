// Source : https://leetcode.com/problems/interleaving-string/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given s1, s2, and s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * Example 3:
 * 
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 * 
 * Constraints:
 * 
 * 	0 <= s1.length, s2.length <= 100
 * 	0 <= s3.length <= 200
 * 	s1, s2, and s3 consist of lower-case English letters.
 ******************************************************************************************************/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null
            || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        var len1 = s1.length();
        var len2 = s2.length();
        
        var dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (var i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (var j = 1; j <= len2; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (var i = 1; i <= len1; i++) {
            for (var j = 1; j <= len2; j++) {
                dp[i][j]
                    = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                    || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        
        return dp[len1][len2];
    }
}