#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 09:51:46
LastEditor: John
LastEditTime: 2020-08-06 09:55:18
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/container-with-most-water/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, 
# ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
# Find two lines, which together with x-axis forms a container, such that the container contains the 
# most water.
# 
# Note: You may not slant the container and n is at least 2.
# 
# The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area 
# of water (blue section) the container can contain is 49. 
# 
# Example:
# 
# Input: [1,8,6,2,5,4,8,3,7]
# Output: 49
#####################################################################################################

class Solution:
    ''' 双指针法
    '''
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        ans = 0
        while l < r:
            area = min(height[l], height[r]) * (r - l)
            ans = max(ans, area)
            if height[l] <= height[r]:
                l += 1
            else:
                r -= 1
        return ans

