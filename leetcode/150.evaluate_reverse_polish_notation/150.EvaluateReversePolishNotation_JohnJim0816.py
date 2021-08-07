#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-10 10:40:54
LastEditor: John
LastEditTime: 2020-08-10 10:41:09
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/evaluate-reverse-polish-notation/
# Author : JohnJim0816
# Date   : 2020-08-10

##################################################################################################### 
#
# Evaluate the value of an arithmetic expression in Reverse Polish Notation.
# 
# Valid operators are +, -, *, /. Each operand may be an integer or another expression.
# 
# Note:
# 
# 	Division between two integers should truncate toward zero.
# 	The given RPN expression is always valid. That means the expression would always evaluate 
# to a result and there won't be any divide by zero operation.
# 
# Example 1:
# 
# Input: ["2", "1", "+", "3", "*"]
# Output: 9
# Explanation: ((2 + 1) * 3) = 9
# 
# Example 2:
# 
# Input: ["4", "13", "5", "/", "+"]
# Output: 6
# Explanation: (4 + (13 / 5)) = 6
# 
# Example 3:
# 
# Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
# Output: 22
# Explanation: 
#   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
# = ((10 * (6 / (12 * -11))) + 17) + 5
# = ((10 * (6 / -132)) + 17) + 5
# = ((10 * 0) + 17) + 5
# = (0 + 17) + 5
# = 17 + 5
# = 22
# 
#####################################################################################################

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        pop_list = []
        for i in tokens:
            if i in "+-*/":
                tmp1 = pop_list.pop()
                tmp2 = pop_list.pop()
                pop_list.append(str(int(eval(tmp2+i+tmp1))))
            else:
                pop_list.append(i)
        return int(pop_list[0])