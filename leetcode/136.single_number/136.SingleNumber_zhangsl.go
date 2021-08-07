// Source : https://leetcode.com/problems/single-number/
// Author : zhangsl
// Date   : 2020-08-13
package main
/***************************************************************************************************** 
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single 
 * one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra 
 * memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 ******************************************************************************************************/


// 思路1:使用 map做标记
// 思路2：由于重复的数字都是偶数，所有可以利用异或的特性 ，按位筛选
// time:76.42 mem:63.40
func singleNumber(nums []int) int {
	ans:=0
	for _,v:=range nums{
		ans^=v
	}
	return ans
}