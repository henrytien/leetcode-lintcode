#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 09:52:05
LastEditor: John
LastEditTime: 2020-08-06 09:54:00
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
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height)-1
        water = 0
        while i < j:
            water = max(water, (j-i)*min(height[i],height[j]))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return water