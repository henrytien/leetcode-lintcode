#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-08 08:57:30
LastEditor: John
LastEditTime: 2020-08-08 08:59:53
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/intersection-of-two-arrays-ii/
# Author : JohnJim0816
# Date   : 2020-08-08

##################################################################################################### 
#
# Given two arrays, write a function to compute their intersection.
# 
# Example 1:
# 
# Input: nums1 = [1,2,2,1], nums2 = [2,2]
# Output: [2,2]
# 
# Example 2:
# 
# Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# Output: [4,9]
# 
# Note:
# 
# 	Each element in the result should appear as many times as it shows in both arrays.
# 	The result can be in any order.
# 
# Follow up:
# 
# 	What if the given array is already sorted? How would you optimize your algorithm?
# 	What if nums1's size is small compared to nums2's size? Which algorithm is better?
# 	What if elements of nums2 are stored on disk, and the memory is limited such that you 
# cannot load all elements into the memory at once?
# 
#####################################################################################################

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 使较长的数组变为nums1
        if len(nums1) > len(nums2):
            tmp = nums1
            nums1 = nums2
            nums2 = tmp
        num1_map = {}
        for num in nums1:
            num1_map[num] = num1_map.get(num, 0) + 1
        res = []
        for num in nums2:
            if num1_map.get(num, 0) > 0:
                res.append(num)
                num1_map[num] -= 1
        return res