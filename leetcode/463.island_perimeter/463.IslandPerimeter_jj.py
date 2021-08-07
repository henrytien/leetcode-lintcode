#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 21:37:48
@LastEditor: John
@LastEditTime: 2020-07-17 21:39:49
@Discription: 
@Environment: python 3.7.7
'''

class Solution:
    '''双重for
    '''
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        nr = len(grid)
        if nr == 0:
            return 0
        nc = len(grid[0])
        n_ones = 0
        n_neighbors = 0
        for r in range(nr):
            for c in range(nc):
                if grid[r][c] == 1:
                    n_ones += 1
                    for x, y in [(r - 1, c), (r + 1, c), (r, c - 1), (r, c + 1)]:
                        if 0 <= x < nr and 0 <= y < nc and grid[x][y] == 1:
                            n_neighbors += 1
        perimeter = 4 * n_ones - n_neighbors
        return perimeter