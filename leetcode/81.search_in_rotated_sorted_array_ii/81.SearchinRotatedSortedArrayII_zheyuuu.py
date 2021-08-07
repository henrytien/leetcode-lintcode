#!/usr/bin/env python
# coding=utf-8
# Source : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
# Author : zheyuuu 
# Date   : 2020-07-21

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
from typing import List
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums:
            return False
        if len(nums)==1:
            return nums[0]==target
        n = len(nums)
        l, r = 0, n-1
        while(l<=r):
            mid = (l+r)//2
            if nums[mid]==target:
                return True
            if nums[mid]==nums[l]==nums[r]:
                new = mid
                while(new<=r and nums[new]==nums[mid]):
                    new += 1
                if new == r+1:
                    r = mid-1
                else:
                    l = new
            elif nums[mid]>=nums[l]:
                # 左边有序
                if nums[l]<=target<nums[mid]:
                    r = mid-1
                else:
                    l = mid+1
            elif nums[mid]<=nums[r]:
                # 右边有序
                if nums[mid]<target<=nums[r]:
                    l = mid+1
                else:
                    r = mid-1
        return False