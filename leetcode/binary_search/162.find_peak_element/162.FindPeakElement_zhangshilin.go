// Source : https://leetcode.com/problems/find-peak-element/
// Author : zhangshilin
// Date   : 2020-07-23
package main

/*****************************************************************************************************
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] &ne; nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -&infin;.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 *
 * Follow up: Your solution should be in logarithmic complexity.
 ******************************************************************************************************/
// 出现下坡 就是峰值，特殊情况为一直是上坡，此时直接返回 len-1
func findPeakElement(nums []int) int {
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] > nums[i+1] {
			return i
		}
	}
	return len(nums) - 1
}

//todo: bin_search method
