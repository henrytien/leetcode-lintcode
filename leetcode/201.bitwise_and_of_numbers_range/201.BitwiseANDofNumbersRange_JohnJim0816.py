#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-23 01:11:17
LastEditor: John
LastEditTime: 2020-08-23 01:12:46
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/bitwise-and-of-numbers-range/
# Author : JohnJim0816
# Date   : 2020-08-23

##################################################################################################### 
#
# Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this 
# range, inclusive.
# 
# Example 1:
# 
# Input: [5,7]
# Output: 4
# 
# Example 2:
# 
# Input: [0,1]
# Output: 0
#####################################################################################################

class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        shift = 0   
        # 找到公共前缀
        while m < n:
            m = m >> 1
            n = n >> 1
            shift += 1
        return m << shift

class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        while m < n:
            # 抹去最右边的 1
            n = n & (n - 1)
        return n

