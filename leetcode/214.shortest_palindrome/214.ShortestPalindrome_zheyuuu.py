# Source : https://leetcode.com/problems/shortest-palindrome/
# Author : zheyuuu
# Date   : 2020-07-26

##################################################################################################### 
#
# Given a string s, you are allowed to convert it to a palindrome by adding characters in front of 
# it. Find and return the shortest palindrome you can find by performing this transformation.
# 
# Example 1:
# 
# Input: "aacecaaa"
# Output: "aaacecaaa"
# 
# Example 2:
# 
# Input: "abcd"
# Output: "dcbabcd"
#####################################################################################################

class Solution:
    # O(n^2) TLE
    def shortestPalindrome(self, s: str) -> str:
        s = s[::-1]
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        t = 1
        for i in range(1,n):
            for j in range(0, i):
                if s[i]==s[j]:
                    if i-1!=j:
                        dp[j][i] = dp[j][i] or dp[j+1][i-1]
                    else:
                        dp[j][i] = True
                    if i==n-1 and dp[j][i]:
                        t = max(t, i-j+1)   
        return s+s[:n-t][::-1]
    
    # O(n)
    # TODO: KMP