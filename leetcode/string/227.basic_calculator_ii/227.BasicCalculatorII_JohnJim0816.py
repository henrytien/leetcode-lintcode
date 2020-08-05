#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-06 00:54:55
LastEditor: John
LastEditTime: 2020-08-06 01:01:33
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/basic-calculator-ii/
# Author : JohnJim0816
# Date   : 2020-08-06

##################################################################################################### 
#
# Implement stack basic calculator to evaluate stack simple expression string.
# 
# The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . 
# The integer division should truncate toward zero.
# 
# Example 1:
# 
# Input: "3+2*2"
# Output: 7
# 
# Example 2:
# 
# Input: " 3/2 "
# Output: 1
# 
# Example 3:
# 
# Input: " 3+5 / 2 "
# Output: 5
# 
# Note:
# 
# 	You may assume that the given expression is always valid.
# 	Do not use the eval built-in library function.
# 
#####################################################################################################

import operator
class Solution(object):
    def calculate(self, s):
        '''注意，python中-3/2==-2，因此需要用到高效率operator.truediv
        '''
        stack = []
        opmp = {
            "+": lambda e: stack.append(e),
            "-": lambda e: stack.append(-e),
            "*": lambda e: stack.append(e * stack.pop()),
            "/": lambda e: stack.append(int(operator.truediv(stack.pop(), e)))
        }
        op = "+"
        num = 0
        for c in s+"+":
            if c.isdigit():
                num = num * 10 + int(c)
            elif c != " ":
                opmp[op](num)
                op = c
                num = 0
        return sum(stack)