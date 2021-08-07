# Source : https://leetcode.com/problems/find-all-anagrams-in-a-string/
# Author : YipingPan
# Date   : 2020-08-13

##################################################################################################### 
#
# Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
# 
# Strings consists of lowercase English letters only and the length of both strings s and p will not 
# be larger than 20,100.
# 
# The order of output does not matter.
# 
# Example 1:
# 
# Input:
# s: "cbaebabacd" p: "abc"
# 
# Output:
# [0, 6]
# 
# Explanation:
# The substring with start index = 0 is "cba", which is an anagram of "abc".
# The substring with start index = 6 is "bac", which is an anagram of "abc".
# 
# Example 2:
# 
# Input:
# s: "abab" p: "ab"
# 
# Output:
# [0, 1, 2]
# 
# Explanation:
# The substring with start index = 0 is "ab", which is an anagram of "ab".
# The substring with start index = 1 is "ba", which is an anagram of "ab".
# The substring with start index = 2 is "ab", which is an anagram of "ab".
# 
#####################################################################################################


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s)<len(p): return []
        cp = [0]*26
        cs = [0]*26
        def idx(x):
            return ord(x) - ord('a')
        for x in p:
            cp[idx(x)] += 1
        for x in s[:len(p)]:
            cs[idx(x)] += 1
        res = []
        i = len(p)-1
        while (1):
            if cs == cp:
                res.append(i-len(p)+1)
            i += 1
            if i == len(s):
                break
            cs[idx(s[i-len(p)])] -= 1
            cs[idx(s[i])] += 1
        return res
        
        
        