#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-24 11:15:35
@LastEditor: John
@LastEditTime: 2020-07-24 11:15:42
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/unique-paths-ii/
# Author : JohnJim0816
# Date   : 2020-07-24

##################################################################################################### 
#
# A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
# 
# The robot can only move either down or right at any point in time. The robot is trying to reach the 
# bottom-right corner of the grid (marked 'Finish' in the diagram below).
# 
# Now consider if some obstacles are added to the grids. How many unique paths would there be?
# 
# An obstacle and empty space is marked as 1 and 0 respectively in the grid.
# 
# Note: m and n will be at most 100.
# 
# Example 1:
# 
# Input:
# [
#   [0,0,0],
#   [0,1,0],
#   [0,0,0]
# ]
# Output: 2
# Explanation:
# There is one obstacle in the middle of the 3x3 grid above.
# There are two ways to reach the bottom-right corner:
# 1. Right -> Right -> Down -> Down
# 2. Down -> Down -> Right -> Right
# 
#####################################################################################################

class Solution:
    '''动态规划+空间优化O(n)'''
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        if obstacleGrid[0][0]:
            return 0
        dp = [0] * (n + 1)
        dp[1] = 1
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if obstacleGrid[i - 1][j - 1] == 0:
                    dp[j] += dp[j - 1]
                else:
                    dp[j] = 0
        return dp[-1]