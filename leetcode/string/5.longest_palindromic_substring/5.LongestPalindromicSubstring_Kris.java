// Source : https://leetcode.com/problems/longest-palindromic-substring/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum 
 * length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 ******************************************************************************************************/

class Solution {
    // Manacher
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        var ss = new char[s.length() * 2 + 1];
        Arrays.fill(ss, '#');
        for (var i = 0; i < s.length(); i++) {
            ss[2 * i + 1] = s.charAt(i);
        }
        
        var pos = 0;
        var center = 0;
        var radius = new int[ss.length];
        for (var i = 0; i < ss.length; i++) {
            var left = i - 1;
            var right = i + 1;
            
            if (center + radius[center] > i) {
                if (2 * center - i - radius[2 * center - i] > center - radius[center]) {
                    radius[i] = radius[2 * center - i];
                    continue;
                } else if (2 * center - i - radius[2 * center - i] < center - radius[center]) {
                    radius[i] = center + radius[center] - i;
                    continue;
                }
                
                radius[i] = center + radius[center] - i;
                left = i - (center + radius[center] - i) - 1;
                right = i + (center + radius[center] - i) + 1;
            }
            
            while (left >= 0 && right < ss.length && ss[left--] == ss[right++]) {
                radius[i]++;
            }
            
            center = i;
            if (radius[i] > radius[pos]) {
                pos = i;
            }
        }
        
        var sb = new StringBuilder();
        for (var i = pos - radius[pos]; i <= pos + radius[pos]; i++) {
            if (ss[i] != '#') {
                sb.append(ss[i]);
            }
        }
        
        return sb.toString();
    }
}