// Source : https://leetcode.com/problems/palindromic-substrings/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 * 
 * The substrings with different start indexes or end indexes are counted as different substrings even 
 * they consist of same characters.
 * 
 * Example 1:
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * Example 2:
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * Note:
 * 
 * 	The input string length won't exceed 1000.
 * 
 ******************************************************************************************************/

class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        var palindromes = new boolean[s.length()][s.length()];
        for (var i = 0; i < s.length(); i++) {
            var left = i;
            var right = i;
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromes[left][right] = true;
                left--;
                right++;
            }
            
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                palindromes[left][right] = true;
                left--;
                right++;
            }
        }
        
        var sum = 0;
        var dp = new int[s.length()];
        for (var i = 0; i < s.length(); i++) {
            for (var j = 0; j <= i; j++) {
                if (palindromes[j][i]) {
                    dp[i] += 1;
                }
            }
            sum += dp[i];
        }
        
        return sum;
    }
}