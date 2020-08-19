#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-15 10:57:52
LastEditor: John
LastEditTime: 2020-08-15 10:58:10
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/running-sum-of-1d-array/
# Author : JohnJim0816
# Date   : 2020-08-15

##################################################################################################### 
#
# Given an array nums. We define a running sum of an array as runningSum[i] = 
# sum(nums[0]&hellip;nums[i]).
# 
# Return the running sum of nums.
# 
# Example 1:
# 
# Input: nums = [1,2,3,4]
# Output: [1,3,6,10]
# Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
# 
# Example 2:
# 
# Input: nums = [1,1,1,1,1]
# Output: [1,2,3,4,5]
# Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
# 
# Example 3:
# 
# Input: nums = [3,1,2,10,1]
# Output: [3,4,6,16,17]
# 
# Constraints:
# 
# 	1 <= nums.length <= 1000
# 	-10^6 <= nums[i] <= 10^6
#####################################################################################################

class Solution:
    ''' DP雏形
    '''
    def runningSum(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        for i in range(1,len(nums)):
            nums[i]=nums[i]+nums[i-1]
        return nums
