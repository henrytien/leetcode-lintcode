#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-20 08:42:09
@LastEditor: John
@LastEditTime: 2020-07-20 08:42:23
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/search-insert-position/
# Author : JohnJim0816
# Date   : 2020-07-20

##################################################################################################### 
#
# Given a sorted array and a target value, return the index if the target is found. If not, return 
# the index where it would be if it were inserted in order.
# 
# You may assume no duplicates in the array.
# 
# Example 1:
# 
# Input: [1,3,5,6], 5
# Output: 2
# 
# Example 2:
# 
# Input: [1,3,5,6], 2
# Output: 1
# 
# Example 3:
# 
# Input: [1,3,5,6], 7
# Output: 4
# 
# Example 4:
# 
# Input: [1,3,5,6], 0
# Output: 0
# 
#####################################################################################################

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        n = len(nums)
        left, right = 0, n-1
        ans = n
        while left <= right:
            mid = (left+right)//2
            if target <= nums[mid] :
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans
