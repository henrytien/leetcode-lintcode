# Source : https://leetcode.com/problems/rotting-oranges
# Author : zheyuuu
# Date   : 2020-07-31

##################################################################################################### 
#
# In a given grid, each cell can have one of three values:
# 
# 	the value 0 representing an empty cell;
# 	the value 1 representing a fresh orange;
# 	the value 2 representing a rotten orange.
# 
# Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
# 
# Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is 
# impossible, return -1 instead.
# 
# Example 1:
# 
# Input: [[2,1,1],[1,1,0],[0,1,1]]
# Output: 4
# 
# Example 2:
# 
# Input: [[2,1,1],[0,1,1],[1,0,1]]
# Output: -1
# Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because 
# rotting only happens 4-directionally.
# 
# Example 3:
# 
# Input: [[0,2]]
# Output: 0
# Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
# 
# Note:
# 
# 	1 <= grid.length <= 10
# 	1 <= grid[0].length <= 10
# 	grid[i][j] is only 0, 1, or 2.
# 
#####################################################################################################

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m,n = len(grid), len(grid[0])
        vis = [[False for _ in range(n)] for _ in range(m)]
        cnt = 0
        q = []
        for i in range(m):
            for j in range(n):
                if grid[i][j]==1:
                    cnt += 1
                elif grid[i][j] == 2:
                    q.append((i,j))
                    vis[i][j] = True
                    cnt+=1
        if cnt == len(q):
            return 0
        ori = [0,-1,0,1,0]
        ans = -1
        while(q):
            tmp = []
            ans += 1
            while(q):
                r,c  = q.pop(0)
                cnt-=1
                for i in range(4):
                    rr = r+ori[i]
                    cc = c+ori[i+1]
                    if rr>=0 and cc>=0 and rr<m and cc<n and not vis[rr][cc] and grid[rr][cc]==1:
                        vis[rr][cc] = True
                        tmp.append((rr,cc)) 
            q = tmp  
        if cnt==0:
            return ans
        else:
            return -1