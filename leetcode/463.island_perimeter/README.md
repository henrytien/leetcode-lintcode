# 463. Island Perimeter

Difficulty: Easy

https://leetcode.com/problems/island-perimeter/

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

**Example:**
```
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
```
![island](assets/island.png)

Companies: Google

Related Topics: Hash Table


## 方法一：双重for

计算所有1的个数n_ones，然后计算所有重合的边个数n_neighbors，最后周长perimeter = 4 * n_ones - n_neighbors

```python
class Solution:
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

```

## DFS

当水域很大，岛很小的时候，dfs可以跳过大部分水域，而双重for不行。

## TODO
