# https://www.lintcode.com/problem/number-of-islands/description?_from=ladder&&fromId=1
# Tag Search, DFS
# Time complexity: O(mn)
# Space complexity: O(mn)

class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """
    def numIslands(self, grid):
        w = len(grid)
        if w == 0:
            return 0
        l = len(grid[0])
        ans = 0
        for y in range(w):
            for x in range(l):
                if grid[y][x] == 1:
                    ans += 1
                    self.dfs(grid, x, y, l, w)
        return ans

    def dfs(self, grid, x, y, l, w):
        if x < 0 or y < 0 or x >= l or y >= w or grid[y][x] == 0:
            return
        grid[y][x] = 0
        self.dfs(grid, x-1, y, l, w)
        self.dfs(grid, x+1, y, l, w)
        self.dfs(grid, x, y-1, l, w)
        self.dfs(grid, x, y+1, l, w)


if __name__ == '__main__':
    grid = [
        [1, 1, 0, 0, 0],
        [0, 1, 0, 0, 1],
        [0, 0, 0, 1, 1],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 1]
    ]
    Solution().numIslands(grid)
