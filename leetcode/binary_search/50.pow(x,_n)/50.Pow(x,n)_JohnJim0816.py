#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 09:46:12
LastEditor: John
LastEditTime: 2020-08-06 09:46:34
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/powx-n/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# Implement pow(x, n), which calculates x raised to the power n (xn).
# 
# Example 1:
# 
# Input: 2.00000, 10
# Output: 1024.00000
# 
# Example 2:
# 
# Input: 2.10000, 3
# Output: 9.26100
# 
# Example 3:
# 
# Input: 2.00000, -2
# Output: 0.25000
# Explanation: 2-2 = 1/22 = 1/4 = 0.25
# 
# Note:
# 
# 	-100.0 < x < 100.0
# 	n is a 32-bit signed integer, within the range [&minus;231, 231 &minus; 1]
# 
#####################################################################################################

class Solution:
    '''快速幂+迭代
    '''
    def myPow(self, x: float, n: int) -> float:
        def quickMul(N):
            ans = 1.0
            # 贡献的初始值为 x
            x_contribute = x
            # 在对 N 进行二进制拆分的同时计算答案
            while N > 0:
                if N % 2 == 1:
                    # 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                    ans *= x_contribute
                # 将贡献不断地平方
                x_contribute *= x_contribute
                # 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
                N //= 2
            return ans
        
        return quickMul(n) if n >= 0 else 1.0 / quickMul(-n)