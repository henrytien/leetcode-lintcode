#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-20 08:44:51
@LastEditor: John
@LastEditTime: 2020-07-20 08:45:44
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/min-stack/
# Author : JohnJim0816
# Date   : 2020-07-20

##################################################################################################### 
#
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
# 
# 	push(x) -- Push element x onto stack.
# 	pop() -- Removes the element on top of the stack.
# 	top() -- Get the top element.
# 	getMin() -- Retrieve the minimum element in the stack.
# 
# Example 1:
# 
# Input
# ["MinStack","push","push","push","getMin","pop","top","getMin"]
# [[],[-2],[0],[-3],[],[],[],[]]
# 
# Output
# [null,null,null,null,-3,null,0,-2]
# 
# Explanation
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin(); // return -3
# minStack.pop();
# minStack.top();    // return 0
# minStack.getMin(); // return -2
# 
# Constraints:
# 
# 	Methods pop, top and getMin operations will always be called on non-empty stacks.
#####################################################################################################

class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_stack = [math.inf]


    def push(self, x: int) -> None:
        self.stack.append(x)
        self.min_stack.append(min(x,self.min_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]