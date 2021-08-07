# Source : https://leetcode.com/problems/first-unique-character-in-a-string/
# Author : YipingPan
# Date   : 2020-08-13

##################################################################################################### 
#
# Given a string, find the first non-repeating character in it and return its index. If it doesn't 
# exist, return -1.
# 
# Examples:
# 
# s = "leetcode"
# return 0.
# 
# s = "loveleetcode"
# return 2.
# 
# Note: You may assume the string contains only lowercase English letters.
#####################################################################################################

class Solution:
    def firstUniqChar(self, s: str) -> int:
        # solution1:
        c = collections.Counter(s)
        for i,x in enumerate(s):
            if c[x] == 1:
                return i 
        return -1
    
        ## solution 2
        # d = {}
        # se = set()
        # for i,x in enumerate(s):
        #     if x not in se:
        #         if x in d:
        #             se.add(x)
        #         else:
        #             d[x] = i
        # for x in s:
        #     if x not in se:
        #         return d[x]
        # return -1        
