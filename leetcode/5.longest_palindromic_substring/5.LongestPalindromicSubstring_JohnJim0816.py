# Source : https://leetcode.com/problems/longest-palindromic-substring/
# Author : JohnJim0816
# Date   : 2020-08-08

##################################################################################################### 
#
# Given a string s, find the longest palindromic substring in s. You may assume that the maximum 
# length of s is 1000.
# 
# Example 1:
# 
# Input: "babad"
# Output: "bab"
# Note: "aba" is also a valid answer.
# 
# Example 2:
# 
# Input: "cbbd"
# Output: "bb"
# 
#####################################################################################################

class Solution:
    '''中心扩展法改进
    '''
    def longestPalindrome(self, s: str) -> str:
        if (s == "" or len(s) < 1): return ""
        start, end = 0, 0
        i=0
        while i<len(s):
            repeat_len=1
            while (i+repeat_len)<=len(s)-1 :
                if s[i]!=s[i+repeat_len]:
                    break
                repeat_len+=1
            len_max=self.expandAroundCenter(s, i, i + repeat_len-1);
            if (len_max>end-start+1):
                start = i - int((len_max-repeat_len) / 2)
                end = i+repeat_len-1 + int((len_max-repeat_len) / 2)
            i=i+repeat_len
        return s[start:end+1]
        
    def expandAroundCenter(self,s,left,right):
        while (left >= 0 and right < len(s) and s[left] == s[right]):
            left-=1
            right+=1
        return right - left - 1