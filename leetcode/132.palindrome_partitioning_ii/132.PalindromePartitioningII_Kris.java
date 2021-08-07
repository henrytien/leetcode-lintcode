// Source : https://leetcode.com/problems/palindrome-partitioning-ii/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example 1:
 * 
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * Example 2:
 * 
 * Input: s = "a"
 * Output: 0
 * 
 * Example 3:
 * 
 * Input: s = "ab"
 * Output: 1
 * 
 * Constraints:
 * 
 * 	1 <= s.length <= 2000
 * 	s consists of lower-case English letters only.
 ******************************************************************************************************/

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        var n = s.length();
        var isPalindrome = new boolean[n][n];
        for (var t = 0; t < n; t++) {
            var i = t;
            var j = t;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalindrome[i--][j++] = true;
            }
            
            i = t;
            j = t + 1;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalindrome[i--][j++] = true;
            }
        }
        
        var dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, n + 1, Integer.MAX_VALUE);

        for (var i = 1; i <= n; i++) {
            for (var j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n] - 1;
    }
    
//     boolean isPalindrome(String s) {
//         if (s == null || s.length() == 0) {
//             return true;
//         }
        
//         var i = 0;
//         var j = s.length() - 1;
//         while (i < j) {
//             if (s.charAt(i++) != s.charAt(j--)) {
//                 return false;
//             }
//         }
        
//         return true;
//     }
}