#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-09 08:12:40
LastEditor: John
LastEditTime: 2020-08-09 08:39:28
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/01-matrix/
# Author : JohnJim0816
# Date   : 2020-08-09

##################################################################################################### 
#
# Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
# 
# The distance between two adjacent cells is 1.
# 
# Example 1: 
# 
# Input:
# [[0,0,0],
#  [0,1,0],
#  [0,0,0]]
# 
# Output:
# [[0,0,0],
#  [0,1,0],
#  [0,0,0]]
# 
# Example 2: 
# 
# Input:
# [[0,0,0],
#  [0,1,0],
#  [1,1,1]]
# 
# Output:
# [[0,0,0],
#  [0,1,0],
#  [1,2,1]]
# 
# Note:
# 
# 	The number of elements of the given matrix will not exceed 10,000.
# 	There are at least one 0 in the given matrix.
# 	The cells are adjacent in only four directions: up, down, left and right.
# 
#####################################################################################################

class Solution:
    '''广度优先搜索,时间复杂度O(rc)，r行数c列数，空O(rc)
    '''
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        dist = [[0] * n for _ in range(m)]
        zeroes_pos = [(i,j) for i in range(m) for j in range(n) if matrix[i][j]==0]
        # 将所有的 0 添加进初始队列中
        q = collections.deque(zeroes_pos)
        seen = set(zeroes_pos)
        # 广度优先搜索
        while q:
            i, j = q.popleft()
            for ni, nj in [(i-1,j),(i+1,j),(i,j+1),(i,j-1)]:
                if 0<=ni<m and 0<=nj<n and (ni,nj) not in seen:
                    dist[ni][nj] = dist[i][j] + 1
                    q.append((ni,nj))
                    seen.add((ni,nj))
        return dist

class Solution:
    ''' 动态规划
    '''
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m, n = len(matrix), len(matrix[0])
        # 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        dist = [[10**9] * n for _ in range(m)]
        # 如果 (i, j) 的元素为 0，那么距离为 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    dist[i][j] = 0
        # 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for i in range(m):
            for j in range(n):
                if i - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1)
                if j - 1 >= 0:
                    dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1)
        # 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i + 1 < m:
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1)
                if j + 1 < n:
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1)
        return dist