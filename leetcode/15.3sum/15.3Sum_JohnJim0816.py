#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-08-02 14:35:13
@LastEditor: John
@LastEditTime: 2020-08-02 14:38:09
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/3sum/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find 
# all unique triplets in the array which gives the sum of zero.
# 
# Note:
# 
# The solution set must not contain duplicate triplets.
# 
# Example:
# 
# Given array nums = [-1, 0, 1, 2, -1, -4],
# 
# A solution set is:
# [
#   [-1, 0, 1],
#   [-1, -1, 2]
# ]
# 
#####################################################################################################

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        n=len(nums)
        ans=[]
        if(not nums or n<3): # 特判
            return []
        nums.sort()
        ans=[]
        for i in range(n):
            if(nums[i]>0):
                return ans
            if(i>0 and nums[i]==nums[i-1]):
                continue
            L=i+1
            R=n-1
            while(L<R):
                if(nums[i]+nums[L]+nums[R]==0):
                    ans.append([nums[i],nums[L],nums[R]])
                    while(L<R and nums[L]==nums[L+1]):
                        L=L+1
                    while(L<R and nums[R]==nums[R-1]):
                        R=R-1
                    L=L+1
                    R=R-1
                elif(nums[i]+nums[L]+nums[R]>0):
                    R=R-1
                else:
                    L=L+1
        return ans