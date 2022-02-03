// Source : https://leetcode.com/problems/wildcard-matching/
// Author : henrytien
// Date   : 2022-02-03

/*****************************************************************************************************
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for
 * '?' and '*' where:
 *
 * 	'?' Matches any single character.
 * 	'*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 *
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 *
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Constraints:
 *
 * 	0 <= s.length, p.length <= 2000
 * 	s contains only lowercase English letters.
 * 	p contains only lowercase English letters, '?' or '*'.
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    bool isMatch(string s, string p)
    {
        int m = s.size(), n = p.size();
        vector<vector<bool>> dp(m + 1, vector<bool>(n + 1, false));

        dp[0][0] = true;
        for (int j = 0; j < n && p[j] == '*'; j++)
        {
            dp[0][j + 1] = true;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '?')
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p[j - 1] == '*')
                {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
};

int main()
{

    string s = "cb", p = "?a";
    cout << Solution().isMatch(s, p) << "\n";
    return 0;
}
