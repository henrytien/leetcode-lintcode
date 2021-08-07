#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-22 11:29:14
@LastEditor: John
@LastEditTime: 2020-07-22 11:29:34
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
# Author : JohnJim0816
# Date   : 2020-07-22

##################################################################################################### 
#
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# 
# (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
# 
# You are given a target value to search. If found in the array return true, otherwise return false.
# 
# Example 1:
# 
# Input: nums = [2,5,6,0,0,1,2], target = 0
# Output: true
# 
# Example 2:
# 
# Input: nums = [2,5,6,0,0,1,2], target = 3
# Output: false
# 
# Follow up:
# 
# 	This is a follow up problem to Search in Rotated Sorted Array, where nums may contain 
# duplicates.
# 	Would this affect the run-time complexity? How and why?
# 
#####################################################################################################

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        n = len(nums)
        if n == 0:
            return False
        left, right = 0, n-1
        while left <= right:
            mid = (left+right)//2
            if nums[mid] == target:
                return True
            if nums[left] == nums[mid]:
                left += 1
                continue
            if nums[left] < nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False