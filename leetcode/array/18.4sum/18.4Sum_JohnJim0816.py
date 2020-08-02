#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-08-02 14:43:34
@LastEditor: John
@LastEditTime: 2020-08-02 14:44:08
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/4sum/
# Author : JohnJim0816
# Date   : 2020-08-02

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
    '''在三数之和排序+双指针的基础上，再加一层for循环。
    '''
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums or len(nums) < 4:
            return []
        nums.sort()
        res = []
        for a in range(len(nums)-3):
            if a > 0 and nums[a] == nums[a-1]:
                continue
            for b in range(a+1,len(nums)-2):
                if b > a+1 and nums[b] == nums[b-1]:
                    continue
                c = b+1
                d = len(nums)-1
                while c < d:
                    sum = nums[a]+nums[b]+nums[c]+nums[d]
                    if sum == target:
                        res.append([nums[a],nums[b],nums[c],nums[d]])
                        while c<d and nums[c] == nums[c+1]:
                            c += 1
                        while c<d and nums[d] == nums[d-1]:
                            d -= 1
                        c += 1
                        d -= 1
                    elif sum < target:
                        c += 1
                    else:
                        d -= 1
        return res