// Source : https://leetcode.com/problems/number-of-islands/
// Author : zhangsl
// Date   : 2020-07-28
package main

import "fmt"

/*****************************************************************************************************
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 ******************************************************************************************************/
//双100
// 思路 遍历整个地图，遇到岩石则+1，并标记包含当前岩石的岛屿
func numIslands(grid [][]byte) int {
	//	 边界检查
	if grid == nil {
		return 0
	}
	ans := 0
	mark := make([][]byte, len(grid))
	for i := 0; i < len(mark); i++ {
		mark[i] = make([]byte, len(grid[0]))
	}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' && mark[i][j] != '1' {
				ans++
				dfs(grid, i, j, mark)
			}
		}
	}
	return ans
}

// mark island
func dfs(mp [][]byte, i, j int, mark [][]byte) {
	if i < 0 || i > len(mp)-1 || j < 0 || j > len(mp[0])-1 || mp[i][j] == '0' || mark[i][j] == '1' {
		return
	}
	// 陆地标记
	mark[i][j] = '1'
	//上
	dfs(mp, i-1, j, mark)
	//下
	dfs(mp, i+1, j, mark)
	//左
	dfs(mp, i, j-1, mark)
	//右
	dfs(mp, i, j+1, mark)
}

func main() {
	arr := [][]byte{{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'}}
	fmt.Println(numIslands(arr))
}
