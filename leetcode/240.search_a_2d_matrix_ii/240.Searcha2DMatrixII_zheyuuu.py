# Source : https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
# Author : zheyuuu
# Date   : 2020-07-26

##################################################################################################### 
#
# Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
# following properties:
# 
# 	Integers in each row are sorted in ascending from left to right.
# 	Integers in each column are sorted in ascending from top to bottom.
# 
# Example:
# 
# Consider the following matrix:
# 
# [
#   [1,   4,  7, 11, 15],
#   [2,   5,  8, 12, 19],
#   [3,   6,  9, 16, 22],
#   [10, 13, 14, 17, 24],
#   [18, 21, 23, 26, 30]
# ]
# 
# Given target = 5, return true.
# 
# Given target = 20, return false.
#####################################################################################################

class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # Use ascending property of matrix
        # Search from left-bottom corner
        # O(m+n)
        if not matrix or not matrix[0]:
            return False
        m, n = len(matrix), len(matrix[0])
        r,c = m-1, 0
        while(r>=0 and c>=0 and r<m and c<n):
            cur = matrix[r][c]
            if cur==target:
                return True
            elif cur<target:
                c = c+1
            else:
                r = r-1
        return False
    def searchMatrix(self, matrix, target):
        # Binary search
        # O(m*logn)
        if not matrix or not matrix[0]:
            return False
        m,n = len(matrix), len(matrix[0])
        for i in reversed(range(m)):
            if matrix[i][0]<= target <= matrix[i][-1]:
                l, r = 0, n
                while(l<r):
                    mid = (l+r)//2
                    if(matrix[i][mid]==target):
                        return True
                    elif(matrix[i][mid]<target):
                        l = mid+1
                    else:
                        r = mid
        return False
        
                    
        
        
        