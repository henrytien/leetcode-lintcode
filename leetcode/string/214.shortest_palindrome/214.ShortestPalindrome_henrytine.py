# Source : https://leetcode.com/problems/shortest-palindrome/
# Author : henrytine
# Date   : 2020-07-23

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
    def shortestPalindrome(self, s: str) -> str:
        r = s[::-1]
        for i in range(len(s) + 1):
            if s.startswith(r[i:]):
                return r[:i] + s
            
        