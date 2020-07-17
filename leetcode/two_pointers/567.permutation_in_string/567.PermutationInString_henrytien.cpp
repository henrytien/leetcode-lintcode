// Source : https://leetcode.com/problems/permutation-in-string/
// Author : henrytine
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
 * 
 * Example 1:
 * 
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * Example 2:
 * 
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * 
 * Constraints:
 * 
 * 	The input strings only contain lower case letters.
 * 	The length of both given strings is in range [1, 10,000].
 ******************************************************************************************************/

// Inspired by https://leetcode.com/problems/permutation-in-string/discuss/102644/C%2B%2B-Java-Clean-Code-with-Explanation
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        const int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) return false;
        
        vector<int> c1(26), c2(26);
        
        for (const char& c : s1)
            ++c1[c - 'a'];
        
        for (int i = 0; i < l2; ++i) {
            ++c2[s2[i] - 'a'];
            if (i >= l1) {
                char c = s2[i - l1];
                --c2[c - 'a'];
            }
            if (c1 == c2) return true;
        }
        return false;
    }
};