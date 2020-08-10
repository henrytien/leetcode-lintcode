// Source : https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author : henrytine
// Date   : 2020-08-10

/***************************************************************************************************** 
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 ******************************************************************************************************/
// The basic idea is, keep a hashmap which stores the characters in string as keys and their positions 
// as values, and keep two pointers which define the max substring.
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        vector<int> dict(256,-1);
        int start = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (dict[s[i]] > start) {
                start = dict[s[i]];
            }
            dict[s[i]] = i;
            cnt = max(cnt, i - start);
        }
        return cnt;
    }
};