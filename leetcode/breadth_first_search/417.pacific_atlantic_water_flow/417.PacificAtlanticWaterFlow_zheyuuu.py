# Author : zheyuuu
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
        m,n = len(matrix), len(matrix[0])
        vis = [[0 for _ in range(n)] for _ in range(m)]
        q1 = []
        q2 = []
        for i in range(m):
            q1.append([i, -1, float("-inf")])
            q2.append([i, n, float("-inf")])
        for j in range(n):
            q1.append([-1, j, float("-inf")])
            q2.append([m, j, float("-inf")])
        ans = []
        d = [0,-1,0,1,0]
        while(q1):
            r,c,pre = q1.pop(0)
            for i in range(4):
                rr,cc = r+d[i], c+d[i+1]
                if rr<0 or cc<0 or rr>=m or cc>=n or vis[rr][cc] == 1 or matrix[rr][cc]<pre:
                    continue
                vis[rr][cc] = 1
                q1.append([rr,cc, matrix[rr][cc]])
        while(q2):
            r,c,pre = q2.pop(0)
            for i in range(4):
                rr,cc = r+d[i], c+d[i+1]
                if rr<0 or cc<0 or rr>=m or cc>=n or vis[rr][cc] == 2 or pre>matrix[rr][cc]:
                    continue
                if vis[rr][cc] == 1:
                    ans.append([rr,cc])
                vis[rr][cc] = 2
                q2.append([rr,cc, matrix[rr][cc]])
        return ans