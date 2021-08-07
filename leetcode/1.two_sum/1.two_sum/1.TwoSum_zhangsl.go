// Source : https://leetcode.com/problems/two-sum/
// Author : zhangsl
// Date   : 2020-08-17
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
//time:97 mem:14

func twoSum(nums []int, target int) []int {
	var (
		mp = map[int]int{}
	)
	for k,_:=range nums{
		mp[nums[k]] = k
	}
	for k,_:=range nums{
		if v,ok:=mp[target-nums[k]];ok&&v!=k{
			return []int{k,v}
		}
	}
	return []int{}
}