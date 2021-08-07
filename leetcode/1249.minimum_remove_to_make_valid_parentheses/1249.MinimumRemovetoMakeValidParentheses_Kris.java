// Source : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given a string s of '(' , ')' and lowercase English characters. 
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that 
 * the resulting parentheses string is valid and return any valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * 	It is the empty string, contains only lowercase characters, or
 * 	It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * 	It can be written as (A), where A is a valid string.
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * 
 * Example 2:
 * 
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * 
 * Example 3:
 * 
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * 
 * Example 4:
 * 
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * 
 * Constraints:
 * 
 * 	1 <= s.length <= 10^5
 * 	s[i] is one of  '(' , ')' and lowercase English letters.
 ******************************************************************************************************/

class Solution {
    public String minRemoveToMakeValid(String s) {        
        var stack = new Stack<Integer>();
        
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        var sb = new StringBuilder();
        for (var i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && i == stack.peek()) {
                stack.pop();
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.reverse().toString();
    }
}