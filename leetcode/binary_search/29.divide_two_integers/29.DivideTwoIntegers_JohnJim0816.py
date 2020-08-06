#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 09:34:46
LastEditor: John
LastEditTime: 2020-08-06 09:35:03
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/divide-two-integers/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# Given two integers dividend and divisor, divide two integers without using multiplication, division 
# and mod operator.
# 
# Return the quotient after dividing dividend by divisor.
# 
# The integer division should truncate toward zero, which means losing its fractional part. For 
# example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
# 
# Example 1:
# 
# Input: dividend = 10, divisor = 3
# Output: 3
# Explanation: 10/3 = truncate(3.33333..) = 3.
# 
# Example 2:
# 
# Input: dividend = 7, divisor = -3
# Output: -2
# Explanation: 7/-3 = truncate(-2.33333..) = -2.
# 
# Note:
# 
# 	Both dividend and divisor will be 32-bit signed integers.
# 	The divisor will never be 0.
# 	Assume we are dealing with an environment which could only store integers within the 32-bit 
# signed integer range: [&minus;231,  231 &minus; 1]. For the purpose of this problem, assume that 
# your function returns 231 &minus; 1 when the division result overflows.
#####################################################################################################

class Solution:
    def divide(self, dividend, divisor):
        i, a, b = 0, abs(dividend), abs(divisor)
        if a == 0 or a < b:
            return 0
        
        while b <= a:
            b = b << 1
            i = i + 1
        else:
            res = (1 << (i - 1)) + self.divide(a - (b >> 1), abs(divisor))
            if (dividend ^ divisor) < 0:
                res = -res

            return min(res, (1 << 31) - 1)