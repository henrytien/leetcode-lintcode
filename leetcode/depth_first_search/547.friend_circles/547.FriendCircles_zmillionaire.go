// Source : https://leetcode.com/problems/friend-circles/
// Author : zmillionaire
// Date   : 2020-08-07
package main

/*****************************************************************************************************
 *
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is
 * transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C,
 * then A is an indirect friend of C. And we defined a friend circle is a group of students who are
 * direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j]
 * = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have
 * to output the total number of friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd
 * student himself is in a friend circle. So return 2.
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct
 * friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend
 * circle, so return 1.
 *
 * Note:
 *
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 *
 ******************************************************************************************************/
//思路：遍历每一个点 每次每标记的都是一个团队）

var (
	mark []int
)

func findCircleNum(m [][]int) int {
	//	边界检查
	if m == nil || len(m) == 0 {
		return 0
	}
	//	初始化
	ans := 0
	mark = make([]int, len(m))
	for i := 0; i < len(m); i++ {
		if mark[i] == 0 {
			ans++
			dfs(m,i)
		}
	}
	return ans
}
func dfs(m [][]int, i int) {
	for j:=0;j<len(m);j++{
		if m[i][j] == 1 && mark[j] == 0 {
			mark[j] = 1
			if i==j{
				continue
			}
			dfs(m,j)
		}
	}
}

//
