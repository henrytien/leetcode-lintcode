#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-07 09:52:47
LastEditor: John
LastEditTime: 2020-08-07 09:53:00
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/find-peak-element/
# Author : JohnJim0816
# Date   : 2020-08-07

##################################################################################################### 
#
# A peak element is an element that is greater than its neighbors.
# 
# Given an input array nums, where nums[i] &ne; nums[i+1], find a peak element and return its index.
# 
# The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
# 
# You may imagine that nums[-1] = nums[n] = -&infin;.
# 
# Example 1:
# 
# Input: nums = [1,2,3,1]
# Output: 2
# Explanation: 3 is a peak element and your function should return the index number 2.
# 
# Example 2:
# 
# Input: nums = [1,2,1,3,5,6,4]
# Output: 1 or 5 
# Explanation: Your function can return either index number 1 where the peak element is 2, 
#              or index number 5 where the peak element is 6.
# 
# Follow up: Your solution should be in logarithmic complexity.
#####################################################################################################

class Solution:
    ''' 二分+迭代
    '''
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        while right > left:
            mid = (left+right)//2
            if nums[mid] < nums[mid+1]:  # nums[mid]处于局部升序,表明峰值在右侧left右移
                left = mid+1
            else:  # 若处于降序(依题不会出现平序)，则指针right左移
                right = mid
        return mid