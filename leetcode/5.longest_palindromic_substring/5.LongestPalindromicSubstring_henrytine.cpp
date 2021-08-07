// Source : https://leetcode.com/problems/longest-palindromic-substring/
// Author : henrytine
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum 
 * length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 ******************************************************************************************************/

class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();
        if(len == 0 || len == 1){
            return s;
        }
        
        int start = 0, length = 0, maxlen = 0;
        for(int i = 0; i < len; ++i){
            length = findLongestPalindromeFrom(s,i,i);
            if(length > maxlen){
                maxlen = length;
                start = i - maxlen / 2;
            }
            
            length = findLongestPalindromeFrom(s,i,i+1);
            if(length > maxlen){
                maxlen = length;
                start = i - maxlen / 2 + 1;
            }
        }
        return s.substr(start,maxlen);
    }
private:
    int findLongestPalindromeFrom(string &s, int left, int right){
        int len = 0;
        while(left >= 0 && right < s.length()){
            if(s[left] != s[right]){
                break;
            }
            len += left == right?1:2;
            left--;
            right++;
        }
        return len;
    }
};