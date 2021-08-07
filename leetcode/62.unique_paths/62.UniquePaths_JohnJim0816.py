#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-24 11:15:11
@LastEditor: John
@LastEditTime: 2020-07-24 11:15:20
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/unique-paths/
# Author : JohnJim0816
# Date   : 2020-07-24

##################################################################################################### 
#
# A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
# 
# The robot can only move either down or right at any point in time. The robot is trying to reach the 
# bottom-right corner of the grid (marked 'Finish' in the diagram below).
# 
# How many possible unique paths are there?
# 
# Above is a 7 x 3 grid. How many possible unique paths are there?
# 
# Example 1:
# 
# Input: m = 3, n = 2
# Output: 3
# Explanation:
# From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
# 1. Right -> Right -> Down
# 2. Right -> Down -> Right
# 3. Down -> Right -> Right
# 
# Example 2:
# 
# Input: m = 7, n = 3
# Output: 28
# 
# Constraints:
# 
# 	1 <= m, n <= 100
# 	It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
#####################################################################################################

class Solution:
    '''动态规划+空间优化O(n)'''
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[-1]
