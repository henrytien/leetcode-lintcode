// Source : https://leetcode.com/problems/counting-bits/
// Author : zmillionaire
// Date   : 2020-09-03
package main
/***************************************************************************************************** 
 *
 * Given a non negative integer number num. For every numbers i in the range 0 &le; i &le; num 
 * calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example 1:
 * 
 * Input: 2
 * Output: [0,1,1]
 * 
 * Example 2:
 * 
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * 
 * Follow up:
 * 
 * 	It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you 
 * do it in linear time O(n) /possibly in a single pass?
 * 	Space complexity should be O(n).
 * 	Can you do it like a boss? Do it without using any builtin function like __builtin_popcount 
 * in c++ or in any other language.
 ******************************************************************************************************/
// 思路
// 思路1：暴力
// 思路2：对于偶数：f(x)=f(x/2),对于奇数：f(x)=f(x-1)+1

// time:91 mem:17

//时间复杂度：o(n)
//空间复杂懂：o(num+1)
func countBits(num int) []int {
	ans:=make([]int,num+1)
	ans[0] = 0
	for i:=1;i<=num;i++{
		if i&1==1{
			ans[i] = ans[i-1]+1
		}else{
			ans[i] = ans[i>>1]
		}
	}
	return ans
}