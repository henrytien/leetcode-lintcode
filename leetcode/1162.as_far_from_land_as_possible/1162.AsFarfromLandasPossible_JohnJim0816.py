#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-09 08:40:38
LastEditor: John
LastEditTime: 2020-08-10 10:38:59
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/as-far-from-land-as-possible/
# Author : JohnJim0816
# Date   : 2020-08-09

##################################################################################################### 
#
# Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, 
# find a water cell such that its distance to the nearest land cell is maximized and return the 
# distance.
# 
# The distance used in this problem is the Manhattan distance: the distance between two cells (x0, 
# y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
# 
# If no land or water exists in the grid, return -1.
# 
# Example 1:
# 
# Input: [[1,0,1],[0,0,0],[1,0,1]]
# Output: 2
# Explanation: 
# The cell (1, 1) is as far as possible from all the land with distance 2.
# 
# Example 2:
# 
# Input: [[1,0,0],[0,0,0],[0,0,0]]
# Output: 4
# Explanation: 
# The cell (2, 2) is as far as possible from all the land with distance 4.
# 
# Note:
# 
# 	1 <= grid.length == grid[0].length <= 100
# 	grid[i][j] is 0 or 1
#####################################################################################################

class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        steps = -1
        island_pos = [(i,j) for i in range(m) for j in range(n) if grid[i][j]==1]
        if len(island_pos) == 0 or len(island_pos) == n ** 2: return steps
        q = collections.deque(island_pos)
        while q:
            for _ in range(len(q)): 
                x, y = q.popleft()
                for xi, yj in [(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)]:
                    if xi >= 0 and xi < n and yj >= 0 and yj < n and grid[xi][yj] == 0:
                        q.append((xi, yj))
                        grid[xi][yj] = -1
            steps += 1             
        return steps