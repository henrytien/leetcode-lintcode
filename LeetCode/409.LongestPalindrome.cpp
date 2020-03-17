// https://leetcode.com/problems/longest-palindrome/
class Solution
{
public:
    int longestPalindrome(string s)
    {
        unordered_map<char, int> hashMap;
        for (auto &c : s)
        {
            if (hashMap.find(c) == hashMap.end())
            {
                hashMap[c] = 1;
            }
            hashMap[c] += 1;
        }

        int cnt = 0;
        for (auto &e : hashMap)
        {
            if (e.second % 2 == 0)
            {
                ++cnt;
            }
        }
        if (cnt > 0)
        {
            cnt -= 1;
        }

        return s.length() - cnt;
    }
};