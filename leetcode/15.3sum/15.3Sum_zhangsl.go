// Source : https://leetcode.com/problems/3sum/
// Author : zhangsl
// Date   : 2020-08-17
package main

import "sort"

/*****************************************************************************************************
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find
 * all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 ******************************************************************************************************/
// 1。首先使用2+1实现3sum
// 2。整合成nSum

//time:30 mem:8
func threeSum(nums []int) [][]int {
	if len(nums) < 1 {
		return nil
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	ans := [][]int{}
	for i := 0; i < len(nums); i++ {
		sub := twoSum(nums, i+1, 0-nums[i])
		for _, v := range sub {
			ans = append(ans, append(v, nums[i]))
		}
		for i < len(nums)-1 && nums[i] == nums[i+1] {
			i++
		}
	}
	return ans
}
func twoSum(nums []int, start, target int) [][]int {
	if len(nums) < 2 || start >= len(nums) {
		return nil
	}
	var (
		l, r = start, len(nums) - 1
		ans  = [][]int{}
	)
	for l < r {
		sum := nums[l] + nums[r]
		left, right := nums[l], nums[r]
		if sum == target {
			ans = append(ans, []int{nums[l], nums[r]})
			for l < r && left == nums[l] {
				l++
			}
			for l < r && right == nums[r] {
				r--
			}
		} else if sum < target {
			for l < r && left == nums[l] {
				l++
			}
		} else if sum > target {
			for l < r && right == nums[r] {
				r--
			}
		}
	}
	return ans
}

// 整合nSum
func nSumTarget(nums []int, start, n, target int) [][]int {
	sz := len(nums)
	if n < 2 || sz < n {
		return nil
	}
	ans := [][]int{}
	if n == 2 {
		l, r := start, sz-1
		for l < r {
			left, right := nums[l], nums[r]
			sum := left + right
			if sum == target {
				ans = append(ans, []int{left, right})
				for l < r && left == nums[l] {
					l++
				}
				for l < r && right == nums[r] {
					r--
				}
			} else if sum < target {
				for l < r && left == nums[l] {
					l++
				}
			} else if sum > target {
				for l < r && right == nums[r] {
					r--
				}
			}
		}
	} else {
		for i := start; i < sz; i++ {
			sub := nSumTarget(nums, i+1, n-1, target-nums[i])
			for _, v := range sub {
				ans = append(ans, append(v, nums[i]))
			}
			for i < sz-1 && nums[i] == nums[i+1] {
				i++
			}
		}
	}
	return ans
}
func threeSum2(nums []int) [][]int{
	if len(nums) < 1 {
		return nil
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	return nSumTarget(nums,0,3,0)
}