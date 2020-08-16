// Source : https://leetcode.com/problems/daily-temperatures/
// Author : zhangsl
// Date   : 2020-08-14
package main

/*****************************************************************************************************
 *
 *
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you
 * how many days you would have to wait until a warmer temperature.  If there is no future day for
 * which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 ******************************************************************************************************/
// 思路1：暴力
//  对于每一个温度，向后遍历，找到离自己最近并且比自己大的，计算index差值
// time O(n^2),
//time:10 mem:92
//todo @zhangshilin The optimal solution
func dailyTemperatures(T []int) []int {
	var(
		ans = make([]int,len(T))
	)
	for i:=0;i<len(T);i++{
		for j:=i+1;j<len(T);j++{
			if T[j]>T[i]{
				ans[i] = j-i
				break
			}
		}
	}
	return ans

}
