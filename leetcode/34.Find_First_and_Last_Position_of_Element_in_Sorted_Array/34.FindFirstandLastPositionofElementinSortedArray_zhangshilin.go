// Source : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Author : zhangshilin
// Date   : 2020-07-21
package main

/*****************************************************************************************************
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of
 * a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Constraints:
 *
 * 	0 <= nums.length <= 10^5
 * 	-10^9 <= nums[i] <= 10^9
 * 	nums is a non decreasing array.
 * 	-10^9 <= target <= 10^9
 ******************************************************************************************************/
func searchRange(nums []int, target int) []int {
	ans := []int{-1, -1}
	if len(nums) == 0 {
		return ans
	}
	left := binSearchLeft(nums, target)
	if left == -1 {
		return ans
	}
	right := binSearchRight(nums, target)
	ans[0] = left
	ans[1] = right
	return ans
}

func binSearchLeft(nums []int, target int) int {
	var (
		left  = 0
		right = len(nums) - 1
		mid   = 0
	)
	for left <= right {
		mid = left + (right-left)/2
		if nums[mid] == target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		}
	}
	if left >= len(nums) || nums[left] != target {
		return -1
	}
	return left
}
func binSearchRight(nums []int, target int) int {
	var (
		left  = 0
		right = len(nums) - 1
		mid   = 0
	)
	for left <= right {
		mid = left + (right-left)/2
		if nums[mid] == target {
			left = mid + 1
		} else if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		}
	}
	if right < 0 || nums[right] != target {
		return -1
	}
	return right
}
