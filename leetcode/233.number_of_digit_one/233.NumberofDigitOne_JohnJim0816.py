#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-02 21:57:29
LastEditor: John
LastEditTime: 2020-08-02 21:58:21
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/number-of-digit-one/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given an integer n, count the total number of digit 1 appearing in all non-negative integers less 
# than or equal to n.
# 
# Example:
# 
# Input: 13
# Output: 6 
# Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
# 
#####################################################################################################

class Solution:
    '''将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数。
    '''
    def countDigitOne(self, n: int) -> int:
        if n <= 0 : return 0
        digit, res = 1, 0
        high, cur, low = n // 10, n % 10, 0
        while high != 0 or cur != 0:
            if cur == 0: res += high * digit
            elif cur == 1: res += high * digit + low + 1
            else: res += (high + 1) * digit
            low += cur * digit
            cur = high % 10
            high //= 10
            digit *= 10
        return res