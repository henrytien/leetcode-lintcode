# Source : https://leetcode.com/problems/perfect-squares/
# Author : yhwhu
# Date   : 2020-07-30

##################################################################################################### 
#
# Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 
# 16, ...) which sum to n.
# 
# Example 1:
# 
# Input: n = 12
# Output: 3 
# Explanation: 12 = 4 + 4 + 4.
# 
# Example 2:
# 
# Input: n = 13
# Output: 2
# Explanation: 13 = 4 + 9.
#####################################################################################################

from collections import deque


class Solution:
    def numSquares(self, n: int) -> int:
        deq = deque()
        deq.append((n, 0))
        visited = {n}
        while deq:
            val, depth = deq.popleft()
            targets = [val - i * i for i in range(1, int(val ** 0.5) + 1)]
            for target in targets:
                if target == 0:
                    return depth + 1
                elif target not in visited:
                    visited.add(target)
                    deq.append((target, depth + 1))
        return -1