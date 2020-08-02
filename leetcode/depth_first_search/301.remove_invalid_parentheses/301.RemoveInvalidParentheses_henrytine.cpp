// Source : https://leetcode.com/problems/remove-invalid-parentheses/
// Author : henrytine
// Date   : 2020-08-02

/***************************************************************************************************** 
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return 
 * all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Example 1:
 * 
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * 
 * Example 2:
 * 
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * 
 * Example 3:
 * 
 * Input: ")("
 * Output: [""]
 ******************************************************************************************************/

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        int left_removed = 0, right_removed = 0;
        unordered_set<string> result;
        for (auto c : s) {
            if (c == '(') {
                ++left_removed;
            }
            if (c == ')') {
                if (left_removed != 0) {
                    --left_removed;
                }
                else {
                    ++right_removed;
                }
            } 
        }
        helper(s, 0, left_removed, right_removed, 0, "", result);
        return vector<string> (result.begin(),result.end());
    }
    
private:
    void helper(string s, int index, int left_removed, int right_removed, int pair, string path, unordered_set<string> &result) {
        if (index == s.size()) {
            // Add the path to result.
            if (pair == 0 && left_removed == 0 && right_removed == 0) {
                result.insert(path);
            }
            return;
        }
        if (s[index] != '(' && s[index] != ')') {
            helper(s, index + 1, left_removed, right_removed, pair, path + s[index], result);
        } else {
            if (s[index] == '(') {
                if (left_removed > 0) {
                    helper(s, index + 1, left_removed - 1, right_removed, pair, path, result);
                }
                helper(s, index + 1, left_removed, right_removed, pair + 1, path + s[index], result);
            }
            // Reverse it and sub the count of left bracket.
            if (s[index] == ')') {
                if (right_removed > 0) {
                    helper(s, index + 1, left_removed, right_removed - 1, pair, path, result);
                }
                if (pair > 0) {
                    helper(s, index + 1, left_removed, right_removed, pair - 1,  path + s[index], result);
                }
            }
         }
    }
};