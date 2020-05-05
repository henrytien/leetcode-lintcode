# https://leetcode.com/problems/longest-palindrome/

# Time Complexity O(n)
# Space Complexity O(128)
# 先统计，然后成对计算
class Solution:
    def longestPalindrome(self, s: str) -> int:
        freqs = [0]*128
        
        for c in s:
            freqs[ord(c)]+=1 
            
        ans , odd = 0, 0
        for freq in freqs:
            ans += freq & (~1)
            odd |= freq & (1)
            
        return ans + odd
            
