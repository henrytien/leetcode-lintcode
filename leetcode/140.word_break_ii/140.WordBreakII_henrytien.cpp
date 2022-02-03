// Source : https://leetcode.com/problems/word-break-ii/
// Author : henrytien
// Date   : 2022-02-03

/*****************************************************************************************************
 *
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
 * where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 * Constraints:
 *
 * 	1 <= s.length <= 20
 * 	1 <= wordDict.length <= 1000
 * 	1 <= wordDict[i].length <= 10
 * 	s and wordDict[i] consist of only lowercase English letters.
 * 	All the strings of wordDict are unique.
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    vector<string> wordBreak(string s, vector<string> &wordDict)
    {
        unordered_map<int, vector<string>> memo{{s.size(), {""}}};

        function<vector<string>(int i)> sentences = [&](int i)
        {
            if (!memo.count(i))
            {
                for (int j = i + 1; j <= s.size(); j++)
                {
                    string token = s.substr(i, j - i);
                    if (std::count(wordDict.begin(), wordDict.end(), token))
                    {
                        for (auto &&tail : sentences(j))
                        {
                            memo[i].push_back(token + (tail == "" ? "" : ' ' + tail));
                        }
                    }
                }
            }
            return memo[i];
        };
        return sentences(0);
    }
};

int main()
{

    string s = "catsanddog";
    vector<string> word_dict = {"cat", "cats", "and", "sand", "dog"};
    // string s = "pineapplepenapple";
    // vector<string> word_dict = {"apple", "pen", "applepen", "pine", "pineapple"};
    // string s = "catsandog";
    // vector<string> word_dict = {"cats", "dog", "sand", "and", "cat"};
    auto v = Solution().wordBreak(s, word_dict);
    for (auto &&iter : v)
        cout << iter << " ";
    cout << "\n";
}
