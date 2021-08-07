// Source : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
// Author : henrytine
// Date   : 2020-08-11

/***************************************************************************************************** 
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * 
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 ******************************************************************************************************/

class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        int n = s.length();
        unordered_map<char, int> hash_map;
        int j = -1, cnt = 0;
        for (int i = 0; i < n; ++i) {
            ++hash_map[s[i]];
            if (hash_map.size() > k) {
               if (--hash_map[s[++j]] == 0)
                   hash_map.erase(s[j]);
            }
            cnt = max(cnt, i - j);
        }
        return cnt;
    }
};