# Source : https://leetcode.com/problems/4sum/
# Author : YipingPan
# Date   : 2020-08-16

##################################################################################################### 
#
# Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
# such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of 
# target.
# 
# Note:
# 
# The solution set must not contain duplicate quadruplets.
# 
# Example:
# 
# Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
# 
# A solution set is:
# [
#   [-1,  0, 0, 1],
#   [-2, -1, 1, 2],
#   [-2,  0, 0, 2]
# ]
# 
#####################################################################################################
class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        dp = collections.defaultdict(int)
        for s in sorted(words,key=len):
            dp[s] = max(dp[s[:i]+s[i+1:]] for i in range(len(s)))+1
        return max(dp.values())

