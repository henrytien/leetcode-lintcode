#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-22 11:28:02
@LastEditor: John
@LastEditTime: 2020-07-22 11:28:19
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
# Author : JohnJim0816
# Date   : 2020-07-22

##################################################################################################### 
#
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# 
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
# 
# You are given a target value to search. If found in the array return its index, otherwise return -1.
# 
# You may assume no duplicate exists in the array.
# 
# Your algorithm's runtime complexity must be in the order of O(log n).
# 
# Example 1:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 0
# Output: 4
# 
# Example 2:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 3
# Output: -1
#####################################################################################################

class Solution:
    def search(self, nums, target):

        l,r = 0, len(nums)-1
        while(l<=r):
            mid = (l+r)//2
            if nums[mid]==target:
                return mid
            elif nums[mid]>=nums[l]:
                if nums[l]<=target<nums[mid]:
                    r = mid-1
                else:
                    l = mid+1
            elif nums[mid]<nums[r]:
                if nums[r]>=target>nums[mid]:
                    l = mid+1
                else:
                    r = mid-1
        return -1