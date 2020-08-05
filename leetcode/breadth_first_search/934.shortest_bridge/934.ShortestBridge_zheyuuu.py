# Source : https://leetcode.com/problems/shortest-bridge/
# Author : zheyuuu
# Date   : 2020-08-04

##################################################################################################### 
#
# In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected 
# group of 1s not connected to any other 1s.)
# 
# Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
# 
# Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at 
# least 1.)
# 
# Example 1:
# Input: A = [[0,1],[1,0]]
# Output: 1
# Example 2:
# Input: A = [[0,1,0],[0,0,0],[0,0,1]]
# Output: 2
# Example 3:
# Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
# Output: 1
# 
# Constraints:
# 
# 	2 <= A.length == A[0].length <= 100
# 	A[i][j] == 0 or A[i][j] == 1
#####################################################################################################

class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        q = []
        n = len(A)
        vis = [[0 for _ in range(n)] for _ in range(n)]

        self.findOneIsland(A, q, vis)
        d = [0,-1,0,1,0]

        while(q):
            r, c, cnt = q.pop(0)
            for i in range(4):
                rr, cc = r+d[i], c+d[i+1]
                if rr>=0 and cc>=0 and rr<n and cc<n and not vis[rr][cc]:
                    if A[rr][cc] == 1:
                        return cnt
                    vis[rr][cc] = 1
                    q.append((rr, cc, cnt+1))
                    
    
    def findOneIsland(self, A, q, vis):
        n = len(A)
        for i in range(n):
            for j in range(n):
                if A[i][j] == 1:
                    vis[i][j] = 1
                    q.append((i,j,0))
                    self.dfs(A, q, vis, i, j)
                    return
    def dfs(self, A, q, vis, r, c):
        d = [0,-1,0,1,0]
        n = len(A)
        for i in range(4):
            rr, cc = r+d[i], c+d[i+1]
            if rr>=0 and cc>=0 and rr<n and cc<n and A[rr][cc]==1 and not vis[rr][cc]:
                vis[rr][cc] = 1
                q.append((rr, cc, 0))
                self.dfs(A, q, vis, rr, cc)
    