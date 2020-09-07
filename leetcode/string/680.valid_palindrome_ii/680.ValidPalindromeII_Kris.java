// Source : https://leetcode.com/problems/valid-palindrome-ii/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge whether you can make it a 
 * palindrome.
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 ******************************************************************************************************/

class Solution {
    public boolean validPalindrome(String s) {
        var ss = s.toCharArray();
        var start = 0;
        var end = ss.length - 1;
        while (start < end) {
            if (ss[start] != ss[end]) {
                return isPalindrome(ss, start + 1, end) || isPalindrome(ss, start, end - 1);
            }
            start++;
            end--;
        }
        
        return true;
    }
    
    boolean isPalindrome(char[] ss, int start, int end) {
        while (start < end) {
            if (ss[start] != ss[end]) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}