// Source : https://leetcode.com/problems/valid-parentheses/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the 
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * 	Open brackets must be closed by the same type of brackets.
 * 	Open brackets must be closed in the correct order.
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * 
 * Input: s = "([)]"
 * Output: false
 * 
 * Example 5:
 * 
 * Input: s = "{[]}"
 * Output: true
 * 
 * Constraints:
 * 
 * 	1 <= s.length <= 104
 * 	s consists of parentheses only '()[]{}'.
 ******************************************************************************************************/

class Solution {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        
        var stack = new Stack<Character>();
        for (var i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}