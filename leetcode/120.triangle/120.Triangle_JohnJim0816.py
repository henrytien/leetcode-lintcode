#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-23 10:51:33
@LastEditor: John
@LastEditTime: 2020-07-23 10:53:00
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/triangle/
# Author : JohnJim0816
# Date   : 2020-07-23

##################################################################################################### 
#
# Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent 
# numbers on the row below.
# 
# For example, given the following triangle
# 
# [
#      [2],
#     [3,4],
#    [6,5,7],
#   [4,1,8,3]
# ]
# 
# The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
# 
# Note:
# 
# Bonus point if you are able to do this using only O(n) extra space, where n is the total number of 
# rows in the triangle.
#####################################################################################################

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        f = [[0] * n for _ in range(n)]
        f[0][0] = triangle[0][0]

        for i in range(1, n):
            f[i][0] = f[i - 1][0] + triangle[i][0]
            for j in range(1, i):
                f[i][j] = min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j]
            f[i][i] = f[i - 1][i - 1] + triangle[i][i]     
        return min(f[n - 1])

class Solution:
    '''动态规划+空间优化,优化为O(n)'''
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        f = [0] * n
        f[0] = triangle[0][0]
        for i in range(1, n):
            f[i] = f[i - 1] + triangle[i][i]
            for j in range(i - 1, 0, -1): # 必须递减
                f[j] = min(f[j - 1], f[j]) + triangle[i][j]
            f[0] += triangle[i][0]
        
        return min(f)