#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-18 09:07:46
@LastEditor: John
@LastEditTime: 2020-07-18 09:08:15
@Discription: 
@Environment: python 3.7.7
'''
class Solution:
    ''' 深度优先搜索
    '''
    def dfs(self, grid, r, c):
        area = 1
        grid[r][c] = 0
        nr, nc = len(grid), len(grid[0])
        for x, y in [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]:
            if 0 <= x < nr and 0 <= y < nc and grid[x][y] == 1:
                area += self.dfs(grid, x, y)
        return area
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        nr = len(grid)
        if nr == 0:
            return 0
        nc = len(grid[0])
        max_area = 0
        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == 1:
                    max_area = max(self.dfs(grid, r, c),max_area)
                    
        return max_area