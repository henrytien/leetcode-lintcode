# Source : https://leetcode.com/problems/divide-two-integers/
# Author : yhwhu
# Date   : 2020-07-25

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
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == 0:
            return 0
        flag = False
        if dividend < 0 and divisor > 0 or dividend > 0 and divisor < 0:
            flag = True
        dividend = abs(dividend)
        divisor = abs(divisor)

        _di = divisor
        res = 0
        while dividend >= _di:
            tmp = 1
            a = _di
            while dividend >= a:
                a = a << 1
                tmp = tmp << 1
            a = a >> 1
            tmp =tmp >> 1
            dividend -= a
            res += tmp
        if flag:
            if res > 1 << 31:
                return (1 << 31) - 1
            return -1 * res
        else:
            if res > (1 << 31) - 1:
                return (1 << 31) - 1
            return res
