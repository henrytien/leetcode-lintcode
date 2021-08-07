// Source : https://leetcode.com/problems/search-a-2d-matrix/
// Author : zhangsl
// Date   : 2020-07-27
package main
/***************************************************************************************************** 
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the 
 * following properties:
 * 
 * 	Integers in each row are sorted from left to right.
 * 	The first integer of each row is greater than the last integer of the previous row.
 * 
 * Example 1:
 * 
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * Example 2:
 * 
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 ******************************************************************************************************/
// 朴素二分，(n*log(m))
func searchMatrix(matrix [][]int, target int) bool {
	bin_search:= func(arr []int,target int)bool {
		l,r,mid:=0,len(arr),0
		for l<=r{
			mid = l+(r-l)/2
			if arr[mid]==target{
				return  true
			}else if arr[mid]<target{
				l = mid+1
			}else{
				r=mid-1
			}
		}
		return false
	}
	for _,row:=range matrix{
		if bin_search(row,target){
			return true
		}
	}
	return false
}
// 根据规律 O(m+n)
func searchMatrix2(matrix [][]int, target int) bool {
	row,col,now:=len(matrix)-1,len(matrix[0])-1,0
	for row>=0 && col<=len(matrix[0])-1{
		now = matrix[row][col]
		if now==target{
			return true
		}else if now> target{
			row--
		}else{
			col++
		}
	}
	return false
}
