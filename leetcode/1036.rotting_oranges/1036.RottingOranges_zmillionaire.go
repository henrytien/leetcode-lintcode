// Source : https://leetcode.com/problems/rotting-oranges/
// Author : zmillionaire
// Date   : 2020-07-31
package main

import (
	"fmt"
)

/*****************************************************************************************************
 *
 * In a given grid, each cell can have one of three values:
 *
 * 	the value 0 representing an empty cell;
 * 	the value 1 representing a fresh orange;
 * 	the value 2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is
 * impossible, return -1 instead.
 *
 * Example 1:
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because
 * rotting only happens 4-directionally.
 *
 * Example 3:
 *
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * Note:
 *
 * 	1 <= grid.length <= 10
 * 	1 <= grid[0].length <= 10
 * 	grid[i][j] is only 0, 1, or 2.
 *
 ******************************************************************************************************/
//思路 多源bfs
// memory 100
func orangesRotting(grid [][]int) int {
	//	 边界检查
	//
	type pair struct {
		r, c int
	}
	var (
		rChange = []int{0, 0, -1, 1}
		cChange = []int{1, -1, 0, 0}
		step    = make([][]int, len(grid))
		cnt     = 0
		ans     = 0
		que     = []pair{}
	)
	for i := 0; i < len(step); i++ {
		step[i] = make([]int, len(grid[0]))
	}
	for i, v1 := range grid {
		for j, _ := range v1 {
			if grid[i][j] == 2 {
				que = append(que, pair{i, j})
				step[i][j] = 0
			} else if grid[i][j] == 1 {
				cnt++
			}
		}
	}
	if cnt==0{
		return 0
	}
	for len(que) != 0 {
		now := que[0]
		que = que[1:]
		for i := 0; i < 4; i++ {
			nr := now.r + rChange[i]
			nc := now.c + cChange[i]
			if nr >= 0 && nr < len(grid) && nc >= 0 && nc < len(grid[0]) && grid[nr][nc] == 1 {
				step[nr][nc] = step[now.r][now.c] + 1 //
				que = append(que, pair{
					r: nr,
					c: nc,
				})
				grid[nr][nc] = 2
				ans = step[nr][nc]
				cnt--
				if cnt == 0 {
					return ans
				}
			}
		}

	}
	return -1


}
func main() {
	arr := [][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}
	fmt.Println(orangesRotting(arr))
}
