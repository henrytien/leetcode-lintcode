# Source : https://leetcode.com/problems/number-of-islands
# Author : zheyuuu
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

class UFS:
    def __init__(self, n):
        self.cnt = n
        self.parents = [i for i in range(n)]
    def find(self,p):
        if p!=self.parents[p]:
            self.parents[p] = self.find(self.parents[p])
        return self.parents[p]
    
    def union(self, a, b):
        aroot = self.find(a)
        broot = self.find(b)
        if aroot!=broot:
            self.parents[broot] = aroot
            self.cnt -=1
            
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0
        m,n = len(grid),len(grid[0])
        ufs = UFS(m*n)
        zeros = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="0":
                    ufs.cnt-=1
                else:
                    if i-1>=0 and grid[i-1][j] == "1":
                        ufs.union(n*(i-1)+j,n*i+j)
                    if j-1>=0 and grid[i][j-1] == "1":
                        ufs.union(n*i+j-1,n*i+j)
        return ufs.cnt
        