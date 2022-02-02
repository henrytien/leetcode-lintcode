// Source : https://leetcode.com/problems/word-break/
// Author : henrytien
// Date   : 2022-02-02

/*****************************************************************************************************
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 * space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 *
 * Constraints:
 *
 * 	1 <= s.length <= 300
 * 	1 <= wordDict.length <= 1000
 * 	1 <= wordDict[i].length <= 20
 * 	s and wordDict[i] consist of only lowercase English letters.
 * 	All the strings of wordDict are unique.
 ******************************************************************************************************/

#include "../inc/ac.h"

class Solution
{
public:
    bool wordBreak(string s, vector<string> &wordDict)
    {
        if (s.empty() || wordDict.size() == 0)
        {
            return false;
        }
        
        vector<bool> dp(s.size()+1,false);
        set<string> dict;
        for (auto &&w : wordDict)
        {
            dict.insert(w);
        }
        
        dp[0] = true;

        for (int i = 1; i <= s.size(); i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (dp[j])
                {
                    string word = s.substr(j,i- j);
                    if (dict.find(word) != dict.end())
                    {
                        dp[i] = true;
                        break;
                    }
                    
                }
            }
        }
        return dp[s.size()];
        
    }
};

int main()
{
    string s = "applepenapple";
    vector<string> word_dict{"apple","pen"};
    cout << Solution().wordBreak(s, word_dict) << "\n";
    return 0;
}