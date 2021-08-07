# Source : https://leetcode.com/problems/minesweeper/
# Author : JohnJim0816
# Date   : 2020-08-20

##################################################################################################### 
#
# Let's play the minesweeper game (Wikipedia, online game)!
# 
# You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' 
# represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent 
# (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many 
# mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
# 
# Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 
# 'E'), return the board after revealing this position according to the following rules:
# 
# 	If a mine ('M') is revealed, then the game is over - change it to 'X'.
# 	If an empty square ('E') with no adjacent mines is revealed, then change it to revealed 
# blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
# 	If an empty square ('E') with at least one adjacent mine is revealed, then change it to a 
# digit ('1' to '8') representing the number of adjacent mines.
# 	Return the board when no more squares will be revealed.
# 
# Example 1:
# 
# Input: 
# 
# [['E', 'E', 'E', 'E', 'E'],
#  ['E', 'E', 'M', 'E', 'E'],
#  ['E', 'E', 'E', 'E', 'E'],
#  ['E', 'E', 'E', 'E', 'E']]
# 
# Click : [3,0]
# 
# Output: 
# 
# [['B', '1', 'E', '1', 'B'],
#  ['B', '1', 'M', '1', 'B'],
#  ['B', '1', '1', '1', 'B'],
#  ['B', 'B', 'B', 'B', 'B']]
# 
# Explanation:
# 
# Example 2:
# 
# Input: 
# 
# [['B', '1', 'E', '1', 'B'],
#  ['B', '1', 'M', '1', 'B'],
#  ['B', '1', '1', '1', 'B'],
#  ['B', 'B', 'B', 'B', 'B']]
# 
# Click : [1,2]
# 
# Output: 
# 
# [['B', '1', 'E', '1', 'B'],
#  ['B', '1', 'X', '1', 'B'],
#  ['B', '1', '1', '1', 'B'],
#  ['B', 'B', 'B', 'B', 'B']]
# 
# Explanation:
# 
# Note:
# 
# 	The range of the input matrix's height and width is [1,50].
# 	The click position will only be an unrevealed square ('M' or 'E'), which also means the 
# input board contains at least one clickable square.
# 	The input board won't be a stage when game is over (some mines have been revealed).
# 	For simplicity, not mentioned rules should be ignored in this problem. For example, you 
# don't need to reveal all the unrevealed mines when the game is over, consider any cases that you 
# will win the game or flag any squares.
# 
#####################################################################################################

import collections
class Solution:
    def updateBoard(self, board, click):
        m, n= len(board),len(board[0])
        def isvalid(x,y):
            if 0 <= x < m and 0 <= y < n:
                return True
            else:
                return False
        def dfs(board, x, y):
            # 直接碰到地雷则改为'X'
            if board[x][y] == 'M':
                board[x][y] = 'X'
                return
            cnt = 0
            mov = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (1, -1), (-1, 1), (1, 1)]
            for dx, dy in mov:
                nx, ny = x + dx , y + dy
                if isvalid(nx, ny):
                    if board[nx][ny] == 'M':
                        cnt += 1
            board[x][y] = 'B' if cnt == 0 else str(cnt)
            if board[x][y] == 'B':
                for dx, dy in mov:
                    nx, ny = x + dx , y + dy
                    if isvalid(nx, ny):
                        if board[nx][ny] == 'E':
                            dfs(board, nx, ny)
        def bfs(board, x, y):
            # 直接碰到地雷则改为'X'
            if board[x][y] == 'M':
                board[x][y] = 'X'
                return
            mov = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (1, -1), (-1, 1), (1, 1)]
            visited = set((x, y))
            q = collections.deque()
            q.append((x, y))
            while q:
                x, y = q.popleft()
                cnt = 0
                # 判断(x,y)相邻的地雷数
                for dx, dy in mov:
                    nx, ny = x + dx , y + dy
                    if isvalid(nx, ny):
                        if board[nx][ny] == 'M':
                            cnt += 1
                # 相邻地雷数为0则改为'B'
                board[x][y] = 'B' if cnt == 0 else str(cnt)
                # 如果是'B'则进一步bfs
                if board[x][y] == 'B':
                    for dx, dy in mov:
                        nx, ny = x + dx , y + dy
                        if isvalid(nx, ny):
                            if (nx, ny) not in visited and board[nx][ny] == 'E':
                                q.append((nx, ny))
                                visited.add((nx, ny))
            return
       
        bfs(board, click[0], click[1])
        # dfs(board, click[0], click[1])
        return board