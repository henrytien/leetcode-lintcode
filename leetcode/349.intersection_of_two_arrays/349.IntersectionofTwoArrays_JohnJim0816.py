#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-07 10:00:12
LastEditor: John
LastEditTime: 2020-08-07 10:00:32
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/intersection-of-two-arrays/
# Author : JohnJim0816
# Date   : 2020-08-07

##################################################################################################### 
#
# Given two arrays, write a function to compute their intersection.
# 
# Example 1:
# 
# Input: nums1 = [1,2,2,1], nums2 = [2,2]
# Output: [2]
# 
# Example 2:
# 
# Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
# Output: [9,4]
# 
# Note:
# 
# 	Each element in the result must be unique.
# 	The result can be in any order.
# 
#####################################################################################################

class Solution:
    ''' 使用python内置函数
    '''
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        set1 = set(nums1)
        set2 = set(nums2)
        return list(set2 & set1)