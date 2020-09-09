// Source : https://leetcode.com/problems/maximum-subarray/
// Author : zmillionaire
// Date   : 2020-09-07
package main

import "math"

/*****************************************************************************************************
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which 
 * has the largest sum and return its sum.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide 
 * and conquer approach, which is more subtle.
 * 
 * Example 1:
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Example 2:
 * 
 * Input: nums = [1]
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: nums = [0]
 * Output: 0
 * 
 * Example 4:
 * 
 * Input: nums = [-1]
 * Output: -1
 * 
 * Example 5:
 * 
 * Input: nums = [-2147483647]
 * Output: -2147483647
 * 
 * Constraints:
 * 
 * 	1 <= nums.length <= 2 * 104
 * 	-231 <= nums[i] <= 231 - 1
 ******************************************************************************************************/
// 思路：维护两个变量ans,sum。ans为当前最大结果，sum为当前累加和，当sum<=0表示不再对ans不再对sum有增益所以将sum更新为新的当前值
// time:100 mem:98
// 复杂度：时间:O(n), 空间:O(1)
//
func maxSubArray(nums []int) int {
	var (
		ans,sum int=math.MinInt32,0
	)
	max:= func(a,b int) int{
		if a<=b{
			return b
		}
		return a
	}
	for i:=0;i<len(nums);i++{
		sum+=nums[i]
		ans = max(ans,sum)
		if sum<=0{
			sum=0
		}
	}
	return ans
}