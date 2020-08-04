# Source : https://leetcode.com/problems/shortest-bridge/
# Author : yhwhu
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
        stack = []
        n = len(A)
        m = len(A[0])
        finish = False
        for i in range(n):
            for j in range(m):
                if A[i][j]:
                    self._dfs(A, i, j, n, m, stack)
                    finish = True
                    break
            if finish:
                break

        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        steps = 0
        while stack:
            new_stack = []
            for _ in range(len(stack)):
                cur_x, cur_y = stack.pop()
                for dx, dy in dirs:
                    new_x = cur_x + dx
                    new_y = cur_y + dy
                    if new_x < 0 or new_y < 0 or new_x >= n or new_y >= n or A[new_x][new_y] == 2:
                        continue
                    if A[new_x][new_y] == 1:
                        return steps
                    A[new_x][new_y] = 2
                    new_stack.append((new_x, new_y))
            steps += 1
            stack = new_stack
        return -1

    def _dfs(self, A, row, col, n, m, stack):
        if row < 0 or col < 0 or row >= n or col >= m or A[row][col] != 1:
            return
        A[row][col] = 2
        stack.append((row, col))
        self._dfs(A, row + 1, col, n, m, stack)
        self._dfs(A, row - 1, col, n, m, stack)
        self._dfs(A, row, col + 1, n, m, stack)
        self._dfs(A, row, col - 1, n, m, stack)