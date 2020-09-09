// Source : https://leetcode.com/problems/minimum-path-sum/
// Author : zhangsl
// Date   : 2020-09-01
package main

/*****************************************************************************************************
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1&rarr;3&rarr;1&rarr;1&rarr;1 minimizes the sum.
 *
 ******************************************************************************************************/
// 思路：动态规划三步骤：确定dp含义，状态转移方程，初始条件
//  <dp含义> 		dp[i][j] 表示从左上角到(i,j)最小的路径和，最后的结果：dp[m][n]
//  <状态转移方程> 	dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
//  <初始条件>  		当在第一行和第一列时，只能从左方向或者上方向过来，所以需要直接初始化

// 复杂度分析
// 												时间复杂度:o(m*n)
//												空间复杂度:o(m*n)
// 状态转移时间：o(1),总共需要转移m*n次-》			时间复杂度
// 需要开辟m*n空间来存储 m*n个状态->				空间复杂度

//Real Time& Mem
//	time:90 mem:57
func minPathSum(grid [][]int) int {
	//	边界检查
	var (
		ans = 0
		dp  = make([][]int, len(grid))
	)
	min:= func(x,y int) int{
		if x<=y{
			return x
		}
		return y
	}
	if grid == nil {
		return ans
	}
	//	 dp数据结构构造
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(grid[i]))
	}
	//dp 初始化
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if i == 0 {
				if j==0{
					dp[i][j] = grid[i][j]
				}else{
					dp[i][j] = dp[i][j-1]+grid[i][j]
				}
			} else if j == 0 {
				dp[i][j] = dp[i-1][j]+grid[i][j]
			} else {
				dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
			}
		}
	}
	return dp[len(grid)-1][len(grid[0])-1]
}
func main() {
//	 边界
//	 单行数据
//	 单列数据
//	 空数据
//	 nil 数组
}