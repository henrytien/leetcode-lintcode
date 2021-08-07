# Source : https://leetcode.com/problems/number-of-islands/
# Author : yhwhu
# Date   : 2020-07-29

##################################################################################################### 
#
# Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
# surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may 
# assume all four edges of the grid are all surrounded by water.
# 
# Example 1:
# 
# Input: grid = [
#   ["1","1","1","1","0"],
#   ["1","1","0","1","0"],
#   ["1","1","0","0","0"],
#   ["0","0","0","0","0"]
# ]
# Output: 1
# 
# Example 2:
# 
# Input: grid = [
#   ["1","1","0","0","0"],
#   ["1","1","0","0","0"],
#   ["0","0","1","0","0"],
#   ["0","0","0","1","1"]
# ]
# Output: 3
#####################################################################################################

from typing import List

class UF:
    def __init__(self, n):
        self.parent = {}
        self.size = [0] * n
        self.cnt = n
        for i in range(n):
            self.parent[i] = i
            self.size[i] = 1

    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def union(self, x, y):
        father_x = self.find(x)
        father_y = self.find(y)
        if father_x == father_y:
            return
        if self.size[father_y] > self.size[father_x]:
            self.parent[father_x] = father_y
            self.size[father_y] += self.size[father_x]
        else:
            self.parent[father_y] = father_x
            self.size[father_x] += self.size[father_y]
        self.cnt -= 1


class Solution:
    def numIslands_uf(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        def get_index(x, y):
            return x * n + y
        uf = UF(m * n + 1)
        positions = [(0, 1), (1, 0)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "0":
                    uf.union(get_index(i, j), m * n)
                elif grid[i][j] == "1":
                    for ii, jj in positions:
                        new_i = i + ii
                        new_j = j + jj
                        if 0 <= new_i < m and 0 <= new_j < n and grid[new_i][new_j] == "1":
                            uf.union(get_index(i, j), get_index(new_i, new_j))

        return uf.cnt - 1


    def numIslands_dfs(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        visited = [[0 for _ in range(n)] for _ in range(m)]
        positions = [(0, -1), (1, 0), (0, 1), (-1, 0)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" and not visited[i][j]:
                    count += 1
                    self._dfs(i, j, grid, m, n, visited, positions)
        return count

    def _dfs(self, i, j, grid, m, n, visited, positions):
        visited[i][j] = 1
        for ii, jj in positions:
            new_i = i + ii
            new_j = j + jj
            if 0 <= new_i < m and 0 <= new_j < n and grid[new_i][new_j] == "1" and not visited[new_i][new_j]:
                self._dfs(new_i, new_j, grid, m, n, visited, positions)

    def numIslands_bfs(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        visited = [[0 for _ in range(n)] for _ in range(m)]
        positions = [(0, -1), (1, 0), (0, 1), (-1, 0)]
        for i in range(m):
            for j in range(n):
                queue = [(i, j)]
                if grid[i][j] == "1" and not visited[i][j]:
                    visited[i][j] = 1
                    count += 1
                    while queue:
                        cur_i, cur_j = queue.pop(0)
                        for ii, jj in positions:
                            new_i = cur_i + ii
                            new_j = cur_j + jj
                            if 0 <= new_i < m and 0 <= new_j < n and grid[new_i][new_j] == "1" and not visited[new_i][
                                new_j]:
                                queue.append((new_i, new_j))
                                visited[new_i][new_j] = 1

        return count


if __name__ == '__main__':
    grid = [["1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","0","1","0","1","1"],["0","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","0"],["1","0","1","1","1","0","0","1","1","0","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","0","1","1","1","1","1","1","0","1","1","1","0","1","1","1","0","1","1","1"],["0","1","1","1","1","1","1","1","1","1","1","1","0","1","1","0","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","1","1"],["1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["0","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","0","1","1","1","1","1","1","1","0","1","1","1","1","1","1"],["1","0","1","1","1","1","1","0","1","1","1","0","1","1","1","1","0","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]
    solution = Solution()
    result = solution.numIslands_uf(grid)
    print(result)

