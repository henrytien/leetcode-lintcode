#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-21 10:09:13
@LastEditor: John
@LastEditTime: 2020-07-21 10:09:21
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
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
# You may assume no duplicate exists in the array.
# 
# Example 1:
# 
# Input: [3,4,5,1,2] 
# Output: 1
# 
# Example 2:
# 
# Input: [4,5,6,7,0,1,2]
# Output: 0
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
            else:
                left = mid + 1
        return nums[left]