// Source : https://leetcode.com/problems/search-a-2d-matrix-ii/
// Author : zhangshilin
// Date   : 2020-07-23
package main

/*****************************************************************************************************
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 *
 * 	Integers in each row are sorted in ascending from left to right.
 * 	Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 ******************************************************************************************************/
// 从右上角或者或者左下角类似于一棵二叉搜索树
//每次移动都缩小一排或者一列的搜索范围，时间复杂度为O(m+n)
func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil {
		return false
	}
	row := len(matrix) - 1
	col := 0
	for row >= 0 && col <= len(matrix[0])-1 {
		if matrix[row][col] == target {
			return true
		} else if matrix[row][col] < target {
			col++
		} else {
			row--
		}
	}
	return false
}

// 二分做法
// 逐行 O(n*log(m))
func searchMatrix2(matrix [][]int, target int) bool {
	binSearch := func(arr []int) bool {
		l := 0
		r := len(arr) - 1
		for l <= r {
			mid := l + (r-l)/2
			if arr[mid] == target {
				return true
			} else if arr[mid] > target {
				r = mid - 1
			} else {
				l = mid + 1
			}
		}
		return false
	}
	for _, row := range matrix {
		if binSearch(row) {
			return true
		}
	}
	return false
}
