// Source : https://leetcode.com/problems/add-binary/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * Constraints:
 * 
 * 	Each string consists only of '0' or '1' characters.
 * 	1 <= a.length, b.length <= 10^4
 * 	Each string is either "0" or doesn't contain any leading zero.
 ******************************************************************************************************/

class Solution {
    public String addBinary(String a, String b) {
        var sb = new StringBuilder();
        var tmp = 0;
        
        for (var i = 0; i < a.length() || i < b.length(); i++) {
            if (i< a.length()) {
                tmp += a.charAt(a.length() - i - 1) - '0';
            }
            if (i < b.length()) {
                tmp += b.charAt(b.length() - i - 1) - '0';
            }
            
            sb.append(tmp % 2);
            tmp /= 2;
        }
        
        if (tmp != 0) {
            sb.append(tmp);
        }
        
        return sb.reverse().toString();
    }
}