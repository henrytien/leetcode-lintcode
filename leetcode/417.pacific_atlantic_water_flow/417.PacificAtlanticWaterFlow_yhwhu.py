# Source : https://leetcode.com/problems/pacific-atlantic-water-flow/
# Author : yhwhu
# Date   : 2020-08-05

##################################################################################################### 
#
# Given an m x n matrix of non-negative integers representing the height of each unit cell in a 
# continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic 
# ocean" touches the right and bottom edges.
# 
# Water can only flow in four directions (up, down, left, or right) from a cell to another one with 
# height equal or lower.
# 
# Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
# 
# Note:
# 
# 	The order of returned grid coordinates does not matter.
# 	Both m and n are less than 150.
# 
# Example:
# 
# Given the following 5x5 matrix:
# 
#   Pacific ~   ~   ~   ~   ~ 
#        ~  1   2   2   3  (5) *
#        ~  3   2   3  (4) (4) *
#        ~  2   4  (5)  3   1  *
#        ~ (6) (7)  1   4   5  *
#        ~ (5)  1   1   2   4  *
#           *   *   *   *   * Atlantic
# 
# Return:
# 
# [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above 
# matrix).
# 
#####################################################################################################


class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or not matrix[0]:
            return []
        self.m = len(matrix)
        self.n = len(matrix[0])
        pacfic = [[0 for _ in range(self.n)] for _ in range(self.m)]
        atlantic = [[0 for _ in range(self.n)] for _ in range(self.m)]

        self.dirs = [(-1, 0), (1, 0), (0, 1), (0, -1)]

        # 左 右
        for i in range(self.m):
            self._dfs(i, 0, matrix, pacfic)
            self._dfs(i, self.n - 1, matrix, atlantic)

        # 上 下
        for j in range(self.n):
            self._dfs(0, j, matrix, pacfic)
            self._dfs(self.m - 1, j, matrix, atlantic)

        res = []
        for i in range(self.m):
            for j in range(self.n):
                if pacfic[i][j] and atlantic[i][j]:
                    res.append([i, j])
        return res

    def _dfs(self, x, y, matrix, tmp):
        tmp[x][y] = 1
        for dx, dy in self.dirs:
            newx = x + dx
            newy = y + dy
            if not self.in_area(newx, newy) or tmp[newx][newy] or matrix[x][y] > matrix[newx][newy]:
                continue
            self._dfs(newx, newy, matrix, tmp)

    def in_area(self, x, y):
        return 0 <= x < self.m and 0 <= y < self.n