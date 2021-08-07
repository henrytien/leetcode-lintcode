#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-30 23:47:22
@LastEditor: John
@LastEditTime: 2020-07-30 23:48:05
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/fibonacci-number/
# Author : JohnJim0816
# Date   : 2020-07-30

##################################################################################################### 
#
# The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such 
# that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
# 
# F(0) = 0,   F(1) = 1
# F(N) = F(N - 1) + F(N - 2), for N > 1.
# 
# Given N, calculate F(N).
# 
# Example 1:
# 
# Input: 2
# Output: 1
# Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
# 
# Example 2:
# 
# Input: 3
# Output: 2
# Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
# 
# Example 3:
# 
# Input: 4
# Output: 3
# Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
# 
# Note:
# 
# 0 &le; N &le; 30.
#####################################################################################################

class Solution:
    '''动态规划
    '''
    def fib(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n):
            a, b = b, a + b
        return a % 1000000007s