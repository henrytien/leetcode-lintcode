#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 21:31:04
@LastEditor: John
@LastEditTime: 2020-07-17 21:31:44
@Discription: 
@Environment: python 3.7.7
'''

class Solution:
    '''深度优先搜索'''
    def dfs(self, grid, r, c):
        grid[r][c] = 0
        nr, nc = len(grid), len(grid[0])
        for x, y in [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]:
            if 0 <= x < nr and 0 <= y < nc and grid[x][y] == "1":
                self.dfs(grid, x, y)

    def numIslands(self, grid: List[List[str]]) -> int:
        nr = len(grid)
        if nr == 0:
            return 0
        nc = len(grid[0])

        num_islands = 0
        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == "1":
                    num_islands += 1
                    self.dfs(grid, r, c)
        
        return num_islands