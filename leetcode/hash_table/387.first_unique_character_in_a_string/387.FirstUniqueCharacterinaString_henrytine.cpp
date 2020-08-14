// Source : https://leetcode.com/problems/first-unique-character-in-a-string/
// Author : henrytine
// Date   : 2020-08-14

/***************************************************************************************************** 
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't 
 * exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode"
 * return 2.
 * 
 * Note: You may assume the string contains only lowercase English letters.
 ******************************************************************************************************/

class Solution {
public:
    int firstUniqChar(string s) {
        int n = s.length();
        if (n == 0) {
            return -1;
        }
        
        int ch[26] = {};
        for (int i = 0; i < n; ++i) {
            ch[s[i]-'a'] ++;
        }
        
        for (int i = 0; i < n; ++i) {
            if (ch[s[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
};