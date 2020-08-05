# Source : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k
# Author : zheyuuu
# Date   : 2020-07-31

##################################################################################################### 
#
# Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix 
# such that its sum is no larger than k.
# 
# Example:
# 
# Input: matrix = [[1,0,1],[0,-2,3]], k = 2
# Output: 2 
# Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
#              and 2 is the max number no larger than k (k = 2).
# 
# Note:
# 
# 	The rectangle inside the matrix must have an area > 0.
# 	What if the number of rows is much larger than the number of columns?
#####################################################################################################
from typing import List
class Solution:

    def maxSumSubmatrix(self, matrix: List[List[int]], K: int) -> int:
        m,n = len(matrix),len(matrix[0])
        ans = -float("inf")
        for i in range(n):
            t = []
            sums = [0 for _ in range(m)]
            for j in range(i,n):
                for k in range(m):
                    sums[k] += matrix[k][j]
                cum_sum = [0]
                cum, max_sum = 0,-float("inf")
                for k in range(m):
                    cum += sums[k]
                    idx = self.bs(cum_sum, cum-K)
                    if(idx<len(cum_sum)):
                        max_sum = max(max_sum, cum-cum_sum[idx])
                    idx = self.bs(cum_sum, cum)
                    cum_sum.insert(idx, cum)
                    t.append(idx)
                ans = max(ans, max_sum)
        return ans

    def bs(self, nums, target):
        l, r = 0, len(nums)
        while(l<r):
            mid = (l+r)//2
            if nums[mid]<target:
                l = mid+1
            else:
                r = mid
        return l