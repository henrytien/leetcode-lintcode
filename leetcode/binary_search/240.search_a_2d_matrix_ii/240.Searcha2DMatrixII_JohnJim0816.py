# Source : https://leetcode.com/problems/search-a-2d-matrix-ii/
# Author : henrytine
# Date   : 2020-07-23

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
        i,j = len(matrix)-1,0
        while i>=0 and j<len(matrix[0]):
            if matrix[i][j]>target: i -=1
            elif matrix[i][j]<target: j+=1
            else: return True
        return False