#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-21 10:26:10
@LastEditor: John
@LastEditTime: 2020-07-21 10:29:03
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
# Author : JohnJim0816
# Date   : 2020-07-21

##################################################################################################### 
#
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
# 
# (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
# 
# Find the minimum element.
# 
# The array may contain duplicates.
# 
# Example 1:
# 
# Input: [1,3,5]
# Output: 1
# 
# Example 2:
# 
# Input: [2,2,2,0,1]
# Output: 0
# 
# Note:
# 
# 	This is a follow up problem to Find Minimum in Rotated Sorted Array.
# 	Would allow duplicates affect the run-time complexity? How and why?
# 
#####################################################################################################

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        right = n - 1
        while left < right:
            mid = (left + right)//2
            if nums[mid] < nums[right]:
                right = mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right -= 1 # 如果相同元素较多会出现此种情况，谨慎左移即可
        return nums[left]