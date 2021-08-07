// Source : https://leetcode.com/problems/generate-parentheses/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed 
 * parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 ******************************************************************************************************/

class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        
        this.total = n;
        helper(n, n, new StringBuilder(), result);
        return result;
    }
    
    void helper(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        
        var existingLeft = total - left;
        var existingRight = total - right;
        if (existingLeft > existingRight && right > 0) {
            helper(left, right - 1, sb.append(')'), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (left > 0) {
            helper(left - 1, right, sb.append('('), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    int total;
}