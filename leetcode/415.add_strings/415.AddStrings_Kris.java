// Source : https://leetcode.com/problems/add-strings/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and 
 * num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is 
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 ******************************************************************************************************/

class Solution {
    public String addStrings(String num1, String num2) {
        var sb = new StringBuilder();

        var len1 = num1.length();
        var len2 = num2.length();
        var tmp = 0;
        for (var i = 1; i <= len1 || i <= len2; i++) {
            if (i <= len1) {
                tmp += num1.charAt(len1 - i) - '0';
            }
            
            if (i <= len2) {
                tmp += num2.charAt(len2 - i) - '0';
            }
            
            sb.insert(0, tmp % 10);
            tmp /= 10;
        }
        
        if (tmp == 1) {
            sb.insert(0, 1);
        }
        
        return sb.toString();
    }
}