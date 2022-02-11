// Source : https://leetcode.com/problems/valid-parenthesis-string/
// Author : henrytien
// Date   : 2022-01-13

/*****************************************************************************************************
 *
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is
 * valid.
 *
 * The following rules define a valid string:
 *
 * 	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 	Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or
 * an empty string "".
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "(*)"
 * Output: true
 * Example 3:
 * Input: s = "(*))"
 * Output: true
 *
 * Constraints:
 *
 * 	1 <= s.length <= 100
 * 	s[i] is '(', ')' or '*'.
 ******************************************************************************************************/

#include "../inc/ac.h"

class Solution1
{
public:
    bool checkValidString(string s)
    {
        int min_open = 0; // Current minimum possible unclosed left braces.
        int max_open = 0; // Current maximum possible unclosed left braces.
        for (auto &&iter : s)
        {
            if (iter == '(')
            {
                min_open += 1;
                max_open += 1;
            }
            else if (iter == ')')
            {
                min_open -= 1;
                max_open -= 1;
            }
            else
            {
                min_open -= 1; // if used as ')'
                max_open += 1; // if used as '('
            }
            // We have a ')' with no possible matching '(' before it
            if (max_open < 0)
            {
                return false;
            }
            // This check server as a guarantee that we won't ever perform this
            // unwanted '*' substitution.
            if (min_open < 0)
                min_open = 0;
        }

        if (min_open == 0)
        {
            return true;
        }

        return false;
    }
};

class Solution {
public:
    bool checkValidString(string s) {
        int min_open = 0, max_open = 0;
        for (auto &&iter : s)
        {
            min_open += iter == '(' ? 1:-1;
            max_open += iter != ')' ? 1:-1;
            if (max_open < 0) break;
            min_open = max(min_open,0);
        }
        return min_open == 0;
    }
};

int main()
{
    string s = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
    cout << Solution().checkValidString(s);
    return 0;
}