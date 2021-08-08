# Source : https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
# Author : zheyuuu
# Date   : 2020-08-02

##################################################################################################### 
#
# Given an n x n binary grid, in one step you can choose two adjacent rows of the grid and swap them.
# 
# A grid is said to be valid if all the cells above the main diagonal are zeros.
# 
# Return the minimum number of steps needed to make the grid valid, or -1 if the grid cannot be valid.
# 
# The main diagonal of a grid is the diagonal that starts at cell (1, 1) and ends at cell (n, n).
# 
# Example 1:
# 
# Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
# Output: 3
# 
# Example 2:
# 
# Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
# Output: -1
# Explanation: All rows are similar, swaps have no effect on the grid.
# 
# Example 3:
# 
# Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
# Output: 0
# 
# Constraints:
# 
# 	n == grid.length
# 	n == grid[i].length
# 	1 <= n <= 200
# 	grid[i][j] is 0 or 1
#####################################################################################################

class Solution:
    # DFS without memorizaton  ---> TLE
    def minSwaps(self, grid: List[List[int]]) -> int:
        self.n = len(grid)
        d = {}
        for i in range(self.n):
            row = grid[i]
            cnt = 0
            j = self.n-1
            while(j>=1 and row[j]==0):
                cnt+=1
                j-=1
            d[i] = [cnt,0]
        self.ans = float("inf")
        self.dfs(0, set([i for i in range(len(grid))]), d, 0)
        if self.ans == float("inf"):
            return -1
        else:
            return self.ans
        
    def dfs(self, row, avaliable, d, cnt):
        if row==self.n-1:
            self.ans = min(self.ans, cnt)
        need = self.n - (row+1)
        for k in avaliable:
            if d[k][0]>=need:
                avaliable.remove(k)
                for i in range(0,k):
                    d[i][1]+=1
                self.dfs(row+1, avaliable, d, cnt+(k-row+d[k][1]))
                avaliable.add(k)
                for i in range(0,k):
                    d[i][1]+=1
    # Sort: O(n^2)  AC
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)
        rows = [0 for _ in range(n)]
        for i in range(n):
            j = n-1
            while(j>=0 and grid[i][j]==0):
                rows[i] +=1
                j -=1
        ans = 0
        for i in range(n):
            j = i
            # Greedy: First row satisfy the condition.
            while(j<n and rows[j]<n-i-1):
                j+=1
            if j==n:
                return -1
            ans += j-i
            for k in reversed(range(i+1, j+1)):
                rows[k] = rows[k-1]
        return ans
            
            
            

                