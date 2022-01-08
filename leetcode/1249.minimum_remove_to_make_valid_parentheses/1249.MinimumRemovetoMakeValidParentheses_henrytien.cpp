// Source : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
// Author : henrytien
// Date   : 2022-01-08

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
 * Constraints:
 *
 * 	1 <= s.length <= 105
 * 	s[i] is either'(' , ')', or lowercase English letter.
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    string minRemoveToMakeValid(string s)
    {
        string res = "";
        if (s.empty())
        {
            return res;
        }

        stack<int> st;
        for (size_t i = 0; i < s.length(); i++)
        {
            if (s[i] == '(')
            {
                st.push(i);
            }
            if (s[i] == ')')
            {
                if (!st.empty())
                {
                    st.pop();
                }
                else
                {
                    s[i] = '*';
                }
            }
        }

        while (!st.empty())
        {
            s[st.top()] = '*';
            st.pop();
        }

        s.erase(remove(s.begin(),s.end(),'*'),s.end());

        return s;
    }
};
int main()
{

    // string s = "lee(t(c)o)de)";
    string s = "))((";
    cout << Solution().minRemoveToMakeValid(s) << endl;
    return 0;
}
