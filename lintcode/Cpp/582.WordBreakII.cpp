// https://www.lintcode.com/problem/word-break-ii/description?_from=ladder&&fromId=1

class Solution
{
public:
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    vector<string> wordBreak(string &s, unordered_set<string> &wordDict)
    {
        if (s.empty())
        {
            return {""};
        }
        unordered_map<int, vector<string>> memo;
        int maxLength = 0;

        for (auto &word : wordDict)
        {
            maxLength = max(maxLength, (int)(word.size()));
        }

        return dfs(0, s, wordDict, maxLength, memo);
    }

private:
    vector<string> dfs(int index,
                       string &s,
                       unordered_set<string> &wordDict,
                       int maxLength,
                       unordered_map<int, vector<string>> &memo)
    {
        if (memo.find(index) != memo.end())
        {
            return memo[index];
        }

        vector<string> result;
        int len = s.length();
        if (index == len)
        {
            return result;
        }

        if (wordDict.find(s.substr(index, len - index)) != wordDict.end())
        {
            result.emplace_back(s.substr(index, len - index));
        }
        for (int i = 1; i <= maxLength; i++)
        {
            if (index + i > s.size())
                break;
            string word = s.substr(index, i);
            if (wordDict.find(word) == wordDict.end())
            {
                continue;
            }

            vector<string> tmp = dfs(index + i, s, wordDict, maxLength, memo);
            for (auto &e : tmp)
            {
                result.push_back(word + " " + e);
            }
        }
        memo[index] = result;
        return result;
    }
};