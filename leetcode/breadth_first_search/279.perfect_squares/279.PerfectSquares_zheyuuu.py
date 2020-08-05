# Source : https://leetcode.com/problems/perfect-squares/
# Author : zheyuuu
# Date   : 2020-07-29

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
class Solution:
    def numSquares(self, n: int) -> int:
        nums = []
        self.memo = {}
        q = []
        for i in range(1, int(n**0.5)+1):
            nums.append(i**2)
        nums = nums[::-1]
        q = [(n,0)]
        while(q):
            cur,cnt = q.pop(0)
            if cur==0:
                return cnt

            for num in nums:
                if cur-num<0:
                    continue

                if cur-num not in self.memo:
                    q.append((cur-num, cnt+1))
                    self.memo[cur-num] = cnt+1
                else:
                    if cnt+1<self.memo[cur-num]:
                        q.append((cur-num, cnt+1))
                        self.memo[cur-num] = cnt+1
        return self.memo[0]  
