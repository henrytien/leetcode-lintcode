#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-12 11:37:51
LastEditor: John
LastEditTime: 2020-08-12 14:49:28
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/daily-temperatures/
# Author : JohnJim0816
# Date   : 2020-08-12

##################################################################################################### 
#
# 
# Given a list of daily temperatures T, return a list such that, for each day in the input, tells you 
# how many days you would have to wait until a warmer temperature.  If there is no future day for 
# which this is possible, put 0 instead.
# 
# For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output 
# should be [1, 1, 4, 2, 1, 1, 0, 0].
# 
# Note:
# The length of temperatures will be in the range [1, 30000].
# Each temperature will be an integer in the range [30, 100].
#####################################################################################################

class Solution:
    '''单调栈法
    '''
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        length = len(T)
        ans = [0] * length
        stack = []
        for i in range(length):
            temperature = T[i]
            while stack and temperature > T[stack[-1]]:
                prev_index = stack.pop()
                ans[prev_index] = i - prev_index
            stack.append(i)
        return ans

class Solution():
    '''从后向前遍历，时O(nm),m是温度范围长度
    '''
    def dailyTemperatures(self, T):
        nxt = [float('inf')] * 102
        ans = [0] * len(T)
        for i in range(len(T) - 1, -1, -1):
            # 获得比当前温度大的最小下标
            warmer_index = min(nxt[t] for t in range(T[i]+1, 102))
            if warmer_index < float('inf'):
                ans[i] = warmer_index - i
            nxt[T[i]] = i
        return ans