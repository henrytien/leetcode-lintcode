#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-24 11:14:40
@LastEditor: John
@LastEditTime: 2020-07-24 11:14:49
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/minimum-path-sum/
# Author : JohnJim0816
# Date   : 2020-07-24

##################################################################################################### 
#
# Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
# which minimizes the sum of all numbers along its path.
# 
# Note: You can only move either down or right at any point in time.
# 
# Example:
# 
# Input:
# [
#   [1,3,1],
#   [1,5,1],
#   [4,2,1]
# ]
# Output: 7
# Explanation: Because the path 1&rarr;3&rarr;1&rarr;1&rarr;1 minimizes the sum.
# 
#####################################################################################################

class Solution:
    '''动态规划+空间优化O(n)'''
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = [float('inf')] * (len(grid[0])+1) # dp[j]表示到第j列的最短路径，并从第0行开始迭代
        dp[1] = 0 
        for row in grid:
            for idx, num in enumerate(row):
                dp[idx + 1] = min(dp[idx], dp[idx + 1]) + num
        return dp[-1]