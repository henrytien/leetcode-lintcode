// Source : https://leetcode.com/problems/two-sum/
// Author : zhangsl
// Date   : 2020-08-10
package main
/***************************************************************************************************** 
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific 
 * target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same 
 * element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 ******************************************************************************************************/

// 思路1 o(n^2)
// 思路2 hash+o(n)
// todo @zhangshilin how to analyse the 红黑树 time complexity

func twoSum(nums []int, target int) []int {
	if len(nums)==0{
		return nums
	}
	ans:=[]int{}
	m:=make(map[int]int)
	for i,v:=range nums{
		m[v] = i
	}
	for i,v:=range nums{
		if index,ok:=m[target-v];ok && i!=index{
			ans  = append(ans, index)
			ans = append(ans, i)
			return ans
		}
	}
	return ans
}