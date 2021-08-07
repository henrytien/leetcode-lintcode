# Source : https://leetcode.com/problems/divide-two-integers/
# Author : zheyuuu
# Date   : 2020-07-27

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
        if(dividend == -2**31 and divisor==-1):
            return 2**31-1
        sign = -1 if (dividend<0) ^ (divisor<0) else 1
        q = 0
        divisor = abs(divisor)
        dividend = abs(dividend)
        while(divisor<=dividend):
            tmp,mul = divisor, 1
            while((tmp<<1)<=dividend):
                tmp <<= 1
                mul <<= 1
            dividend -= tmp
            q += mul
        return sign*q
                